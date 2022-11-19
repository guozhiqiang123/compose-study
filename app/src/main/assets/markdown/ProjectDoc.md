# Compose Study文档

## 项目架构





## 业务逻辑



## 常见技巧

### 条件Modifier

一般这样写：

```kotlin
Box(
    modifier = if (state != RefreshLoadMoreState.CurrNoMore) Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)
    else Modifier
        .fillMaxWidth()
        .clickable {
            loadMoreCallBack()
        }
        .padding(vertical = 8.dp),
    contentAlignment = Alignment.Center,
) {
    
}
```

更好的写法，使用then操作符，缩减代码行数：

```kotlin
Box(
    modifier = Modifier
        .fillMaxWidth()
        .then(if (state == RefreshLoadMoreState.CurrNoMore) Modifier.clickable { loadMoreCallBack() } 
              else Modifier)
        .padding(vertical = 8.dp),
    contentAlignment = Alignment.Center,
) {

}
```



## 常用封装

