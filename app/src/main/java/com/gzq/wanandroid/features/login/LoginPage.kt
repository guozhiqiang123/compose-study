package com.gzq.wanandroid.features.login

import androidx.activity.compose.BackHandler
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import com.gzq.wanandroid.HttpUrl
import com.gzq.wanandroid.R
import com.gzq.wanandroid.core.extension.DisposableRepeatEffect
import com.gzq.wanandroid.features.main.LocalSnackbarHostState
import com.gzq.wanandroid.router.Router
import com.gzq.wanandroid.router.isHomePage
import com.gzq.wanandroid.widget.CustomSnackBar
import com.gzq.wanandroid.widget.LoadingDialog
import com.gzq.wanandroid.widget.MyTopAppBar
import com.gzq.wanandroid.widget.SnackBarState

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.loginPage(
    navController: NavHostController,
    loginController: (Boolean, Boolean) -> Unit,
    showBottomNavigationBar: (Boolean) -> Unit
) {
    composable(Router.LoginPage.route) {
        LoginPage(
            loginController,
            launchRegisterPage = {
                navController.navigate(Router.RegisterPage.route)
            }, launchPrivacyPage = { url ->
                //因为详情页也是网页，所以直接跳了
                navController.navigate(Router.WebViewPage.createRoute(url))
            }, launchUserPage = { url ->
                //因为详情页也是网页，所以直接跳了
                navController.navigate(Router.WebViewPage.createRoute(url))
            }) {
            if (navController.previousBackStackEntry == null) {
                showBottomNavigationBar(true)
                navController.navigate(Router.HomePage.route) {
                    //跳转首页，并且把当前页面导航从栈中移除
                    //防止点击返回又回到了这个页面
                    popUpTo(navController.graph.findStartDestination().id) {
                        inclusive = true
                    }
                }
            } else {
                showBottomNavigationBar(navController.previousBackStackEntry!!.isHomePage())
                navController.popBackStack()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(
    loginController: (Boolean, Boolean) -> Unit,
    viewModel: LoginViewModel = viewModel(),
    launchRegisterPage: () -> Unit,
    launchPrivacyPage: (String) -> Unit,
    launchUserPage: (String) -> Unit,
    clickBack: () -> Unit
) {
    BackHandler(onBack = clickBack)

    val nameTextField = rememberSaveable { mutableStateOf("") }
    val pwdTextField = rememberSaveable { mutableStateOf("") }
    var selectProtocol by rememberSaveable { mutableStateOf(false) }

    val snackbarState = remember { SnackbarHostState() }

    val lifecycleOwner = LocalLifecycleOwner.current

    val showLoading by viewModel.loadingState.observeAsState(false)

    if (showLoading) {
        LoadingDialog { viewModel.updateLoadingState(false) }
    }

    DisposableRepeatEffect(viewModel.loginState, lifecycleOwner, reset = true) {
        if (it == null) return@DisposableRepeatEffect
        when (it) {
            is LoginState.Success -> {
                //登录成功跳转
                loginController(true, true)
                clickBack()
            }

            is LoginState.Error -> {
                snackbarState.showSnackbar(message = it.info)
            }
        }
    }

    CompositionLocalProvider(LocalSnackbarHostState provides snackbarState) {
        Scaffold(
            topBar = {
                MyTopAppBar(
                    backIcon = Icons.Default.Close,
                    clickBack = clickBack,
                    elevation = 0.dp
                )
            },
            snackbarHost = {
                SnackbarHost(hostState = snackbarState) {
                    CustomSnackBar(
                        data = it,
                        state = parseSnackBarState(viewModel.loginState.value)
                    )
                }
            }
        ) { paddingValues ->
            Surface(modifier = Modifier.padding(paddingValues)) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.weight(0.3f))

                    NameAndPassword(nameTextField, pwdTextField)

                    Spacer(modifier = Modifier.weight(0.3f))

                    Button(
                        onClick = {
                            viewModel.tryLogin(
                                selectProtocol,
                                nameTextField.value,
                                pwdTextField.value
                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = stringResource(id = R.string.sign_in))
                    }

                    TextButton(onClick = launchRegisterPage) {
                        Text(text = stringResource(id = R.string.sign_up))
                    }
                    Spacer(modifier = Modifier.weight(0.4f))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = selectProtocol,
                            onClick = { selectProtocol = !selectProtocol })
                        PolicyText(
                            privacyUrl = HttpUrl.Privacy_Policy,
                            userUrl = HttpUrl.User_Policy,
                            clickPrivacy = launchPrivacyPage,
                            clickUser = launchUserPage
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NameAndPassword(
    nameTextField: MutableState<String>,
    pwdTextField: MutableState<String>
) {

    val (pwdTransform, setTransform) = remember {
        mutableStateOf<VisualTransformation>(PasswordVisualTransformation())
    }

    OutlinedTextField(
        value = nameTextField.value,
        onValueChange = {
            nameTextField.value = it
        },
        leadingIcon = {
            Image(
                imageVector = Icons.Default.Person,
                contentDescription = stringResource(id = R.string.user_name)
            )
        },
        label = {
            Text(stringResource(id = R.string.please_input_user_name))
        },
        placeholder = {
            Text(text = stringResource(id = R.string.cannot_contain_special_characters))
        },
        maxLines = 1,
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(16.dp))

    OutlinedTextField(
        value = pwdTextField.value,
        onValueChange = {
            pwdTextField.value = it
        },
        leadingIcon = {
            Image(
                imageVector = Icons.Default.Lock,
                contentDescription = null
            )
        },
        trailingIcon = {
            Icon(
                modifier = Modifier.clickable {
                    setTransform(
                        if (pwdTransform is PasswordVisualTransformation)
                            VisualTransformation.None
                        else PasswordVisualTransformation()
                    )
                },
                painter = painterResource(
                    if (pwdTransform is PasswordVisualTransformation)
                        R.drawable.eye_close
                    else R.drawable.eye_open
                ), contentDescription = stringResource(id = R.string.display_hide_password)
            )

        },
        label = {
            Text(stringResource(id = R.string.please_input_password))
        },
        placeholder = {
            Text(text = stringResource(id = R.string.password_at_least_length))
        },
        visualTransformation = pwdTransform,
        maxLines = 1,
        colors = TextFieldDefaults.outlinedTextFieldColors(),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun PolicyText(
    privacyUrl: String,
    userUrl: String,
    clickPrivacy: (String) -> Unit,
    clickUser: (String) -> Unit
) {
    // 构建注解文本
    val privacyTag = "PrivacyPolicy"
    val userTag = "UserPolicy"

    val text = buildAnnotatedString {
        append(stringResource(id = R.string.i_had_read))

        pushStringAnnotation(
            tag = privacyTag,
            annotation = privacyUrl
        )
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
            append("《${stringResource(id = R.string.privacy_policy)}》")
        }

        append(stringResource(id = R.string.and))

        pushStringAnnotation(
            tag = userTag,
            annotation = userUrl
        )
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
            append("《${stringResource(id = R.string.user_service)}》")
        }
        pop()
    }

    ClickableText(text = text, onClick = { index ->
        text.getStringAnnotations(
            tag = privacyTag,
            start = index,
            end = index
        ).firstOrNull()?.let { annotation ->
            clickPrivacy(annotation.item)
        }
        text.getStringAnnotations(
            tag = userTag,
            start = index, end = index
        ).firstOrNull()?.let { annotation ->
            clickUser(annotation.item)
        }
    })
}

private fun parseSnackBarState(showInfo: LoginState?): SnackBarState {
    if (showInfo == null || showInfo !is LoginState.Error) return SnackBarState.NorMal
    return when (showInfo.type) {
        LoginState.Error.NotSelectProtocol -> SnackBarState.Info
        LoginState.Error.PasswordEmpty -> SnackBarState.Error
        LoginState.Error.UserNameEmpty -> SnackBarState.Error
        LoginState.Error.WrongNameOrPassword -> SnackBarState.Error
        LoginState.Error.OtherError -> SnackBarState.Error
        LoginState.Error.NoNetWork -> SnackBarState.Info
        else -> SnackBarState.NorMal
    }
}