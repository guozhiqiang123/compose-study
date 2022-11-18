package com.gzq.wanandroid.features.register

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import com.gzq.wanandroid.R
import com.gzq.wanandroid.core.extension.DisposableRepeatEffect
import com.gzq.wanandroid.router.Router
import com.gzq.wanandroid.widget.CustomSnackBar
import com.gzq.wanandroid.widget.MyTopAppBar


@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.registerPage(
    navController: NavHostController,
    loginController: (Boolean, Boolean) -> Unit,
    showBottomNavigationBar: (Boolean) -> Unit,
) {
    composable(Router.RegisterPage.route) {
        RegisterPage(registerSuccess = {
            loginController(true, true)
            navController.navigate(Router.HomePage.route) {
                //跳转首页，并且把当前页面导航从栈中移除
                //防止点击返回又回到了这个页面
                popUpTo(navController.graph.findStartDestination().id) {
                    inclusive = true
                }
            }
        }) {
            navController.popBackStack()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterPage(
    viewModel: RegisterViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    registerSuccess: () -> Unit,
    clickBack: () -> Unit,
) {
    val nameTextField = rememberSaveable { mutableStateOf("") }
    val pwdTextField = rememberSaveable { mutableStateOf("") }
    val repwdTextField = rememberSaveable { mutableStateOf("") }
    val snackbarState = remember { SnackbarHostState() }

    DisposableRepeatEffect(viewModel.registerState, LocalLifecycleOwner.current, reset = true) {
        if (it == null) return@DisposableRepeatEffect
        when (it) {
            is RegisterState.ErrorInfo -> snackbarState.showSnackbar(message = it.info)
            is RegisterState.Success -> registerSuccess()
        }

    }
    Scaffold(topBar = {
        MyTopAppBar(title = stringResource(id = R.string.register), clickBack = clickBack)
    }, snackbarHost = {
        SnackbarHost(hostState = snackbarState) {
            CustomSnackBar(data = it)
        }
    }) { paddingValues ->
        Column(
            Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.weight(0.3f))

            NameAndPassword(nameTextField, pwdTextField, repwdTextField)

            Spacer(modifier = Modifier.weight(0.3f))

            Button(
                onClick = {
                    viewModel.register(
                        nameTextField.value,
                        pwdTextField.value,
                        repwdTextField.value
                    )
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(id = R.string.register))
            }

            Spacer(modifier = Modifier.weight(0.4f))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NameAndPassword(
    nameTextField: MutableState<String>,
    pwdTextField: MutableState<String>,
    repwdTextField: MutableState<String>
) {

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
        label = {
            Text(stringResource(id = R.string.please_input_password))
        },
        placeholder = {
            Text(text = stringResource(id = R.string.password_at_least_length))
        },
        maxLines = 1,
        colors = TextFieldDefaults.outlinedTextFieldColors(),
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(16.dp))

    OutlinedTextField(
        value = repwdTextField.value,
        onValueChange = {
            repwdTextField.value = it
        },
        leadingIcon = {
            Image(
                imageVector = Icons.Default.Lock,
                contentDescription = null
            )
        },
        label = {
            Text(stringResource(id = R.string.please_input_password_again))
        },
        placeholder = {
            Text(text = stringResource(id = R.string.twice_password_same))
        },
        maxLines = 1,
        colors = TextFieldDefaults.outlinedTextFieldColors(),
        modifier = Modifier.fillMaxWidth()
    )
}
