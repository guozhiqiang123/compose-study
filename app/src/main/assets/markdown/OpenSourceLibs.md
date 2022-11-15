# Compose 学习总结

Compose发布正式版已经有一段时间了。趁最近比较闲，抓紧学习一波。

学习过程中，主要以实战项目中常用技术为目标。下面是项目地址，会长期更新，希望能给正在学习Compose的小伙伴一点参考。同时您有什么好的建议，也可以提issue给我，我们一起讨论。

项目地址：[https://github.com/guozhiqiang123/compose-study](https://github.com/guozhiqiang123/compose-study)

## 目标

- [x] 配合Retrofit+Okhttp实现数据加载并展示
- [x] 实现列表的上拉加载更多、下来刷新
- [x] 项目采用单页面
- [x] 使用compose-navigation实现路由导航
- [x] 使用ViewModel+LiveData实现MVVM架构
- [ ] 使用ViewModel+Flow（LiveData）实现MVI架构
- [x] 导航动画使用
- [ ] compose中嵌入原生控件
- [x] 常见的动画使用
- [x] 全局状态的管理
- [ ] 适配平板
- [x] 暗黑适配
- [x] 多主题定制，切换
- [ ] 自定义组件
- [x] 国际化
- [ ] 视频列表实现和优化
- [x] 嵌入网页，和js交互
- [ ] compose-permission使用
- [ ] compose-pager使用
- [ ] 流式布局实现和优化
- [x] Material3主题适配
- [ ] 实现至少两个复杂页面并交互
- [x] 登录功能，并实现全局登录状态的同步
- [ ] 本地数据存储Room、DataStore等组件的使用
- [x] 自定义页面状态管理组件
- [x] 代码质量检测工具
- [ ] 老项目混写Compose
- [ ] 其他更高级的功能，想到再补充

## 知识点

这只是我自己学习过程中的笔记和思考，可能不是完全正确，如有错误，忘指正！

### SnackBar的使用

```kotlin
//第一步：
val snackbarHostState = remember { SnackbarHostState() }
//通过kotlin Channel发送消息
val channel = remember { Channel<String>(Channel.CONFLATED) }

//第二步：
LaunchedEffect(key1 = channel) {
    channel.receiveAsFlow().collect {
        snackbarHostState.showSnackbar(it)
    }
}

//第三步：
 Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = Color.Transparent,
        scaffoldState = rememberScaffoldState(snackbarHostState = snackbarHostState)
   ) {
}

//第四步：
channel.trySend("需要显示的文本")
```

### 和ViewModel配合使用

使用ViewModel扩展函数需要添加下面组件：

```kotlin
implementation "androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1"
//示例代码
@Composable
fun HomeMainPage(viewModel: HomeMainViewModel = viewModel()) {}
```

将LiveData转换成State需要添加下面组件：

```kotlin
implementation "androidx.compose.runtime:runtime-livedata:1.2.1"
//示例代码
val counter = viewModel.counter.observeAsState()
```

### 软键盘显示/隐藏的控制

```kotlin
 val keyboard = LocalSoftwareKeyboardController.current
 // ...
 onClick = {
     keyboard?.hide()
     keyboard?.show()
 }
```

### 不借助State手动刷新（不推荐这么做）

```kotlin
//触发当前Composable的recomposition
currentRecomposeScope.invalidate()
```

### Effect的使用

教程：[https://juejin.cn/post/6930785944580653070](https://juejin.cn/post/6930785944580653070)

流程：

![image](https://p6-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/5395e550e6254c2bbe9870bab3e5398b~tplv-k3u1fbpfcp-zoom-in-crop-mark:3024:0:0:0.awebp)

### DisposableEffect

和生命周期相关的逻辑执行使用。比如广播注册和反注册、监听和注销监听等等。

key1传Unit或者true，首次渲染执行一次，重组则不再执行。key1传State，则State值变化，则再次执行。

### SideEffect

每次重组都需要执行的副作用。比如日志打印等等。

### LaunchedEffect

需要调用协程函数的时候使用。

key1传Unit或者true，首次渲染执行一次，重组则不再执行。key1传State，如果State值变化，则再次执行。

如果是条件启动该副作用，条件应该写在外面，而不是LaunchedEffect里面，尽量减少资源的浪费。

### Compose函数中dp转px

```kotlin
import androidx.compose.ui.platform.LocalDensity

val pxValue = with(LocalDensity.current) { 16.dp.toPx() }

// or

val pxValue = LocalDensity.current.run { 16.dp.toPx() }
```

### 设置部分文字不可复制

```kotlin
 // 设置可选区域
 SelectionContainer {
     // Column等价于竖直的LinearLayout
     Column {
         Text(text = "可以选中我，可以选中我，可以选中我")

         // 设置不可选区域
         DisableSelection {
                Text(text = "选不中我，选不中我，选不中")
         }

         // 位于可选区域内，可选
         Text(text = "可以选中我，可以选中我，可以选中我")
     }
 }
```

### 物理返回键的处理

使用BackHandler进行拦截，但是不能写在MaterialTheme的代码块中，否则不生效

```kotlin
@Composable
fun TestPage(){
    BackHandler {
        //TODO:拦截物理返回键
    }
    
    MaterialTheme {
        androidx.compose.material.Scaffold {
            Box(Modifier.padding(it)) {
                
            }
        }
    }
}
```

## 我的一点看法

我之前用Flutter写过几个demo，逐渐熟悉了写Flutter后，感觉写起来真好。特别是Android Studio各种智能补全，写起来特别流畅。所以一直比较抵触学Compose，总感觉比Flutter书写体验差太多了。不过我毕竟还是一个Android开发嘛，还指望着吃这碗饭，所以Android这边的新技术也要学习起来。

写这篇文章的时候，我前前后后学Compose大概花了一周。主要是remember和Effect都是新概念，从接触到理解个大概，花了一些时间。如果有学习过React前端技术的，应该立马就能明白，可惜我并没有这样的经验。

学习了基本的组件后，我就开始写上面这个项目，刚开始写起来有点生疏。比如状态提升什么的，刚开始写完全没注意到。不过随着业务逐渐偏向于实战项目，不断重构和优化代码，状态提升这个东西，自然而然就有了。

代码写的好不好，性能怎么样。除了直觉感受，更重要的是要有工具来检测，于是又到处搜文章看，然后尝试大佬们推荐的做法。工具有了之后，又把之前性能不好的地方重构了下。

总体来说，目前Compose已经很好了，我个人感觉性能上不比原生差。而且函数组合方式真的比类继承好使多了，非常灵活，而且少很多模板代码。写动画真的不要太爽，原生项目写个动画有多痛苦，相信做过原生开发的小伙伴都知道。另外自定义控件比原生容易多了，原生自定义需要理解很多概念，什么ViewGroup，View，事件传递等等。而Compose相对来说理解的概念就少多了，而且代码更简洁。有时候寥寥几句代码，就能实现很复杂的组件。

希望想在Android领域继续讨饭吃的小伙伴都学起来吧！

## 感谢你们（排名不分先后）

* [Android官方教程](https://developer.android.google.cn/jetpack/compose/documentation)
* [程序员江同学](https://juejin.cn/user/668101431009496/columns)
* [funroid](https://juejin.cn/user/3931509309842872/columns)
* [FunnySaltyFish](https://juejin.cn/user/2673613109214333/columns)
* 其他大佬的博文（遇到问题搜索到的，记不住了，望理解）



## 持续更新中...

除了项目持续更新，该文章也会持续更新。大家一起学习，共同进步！



| 1    | 3    | 4    | 5    | 9    | 3    | 4    |
| ---- | ---- | ---- | ---- | ---- | ---- | ---- |
| 7    | 2    | 3    | 4    | 5    | f    | r    |
|      |      |      |      |      |      |      |
|      |      |      |      |      |      |      |

- 11
  - 22
  - 33
    - 234



------

------

~~eeeeeeeeeee~~

> 你好

