package com.gzq.wanandroid.features.home.profile

import androidx.annotation.StringRes
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.gzq.wanandroid.R
import com.gzq.wanandroid.exit_app.MyBackHandler
import com.gzq.wanandroid.features.home.profile.components.LoginWarningDialogC
import com.gzq.wanandroid.features.home.profile.components.LogoutDialogC
import com.gzq.wanandroid.features.home.profile.components.ProfileAvatarC
import com.gzq.wanandroid.features.home.profile.components.ProfileMenuItemC
import com.gzq.wanandroid.features.home.profile.components.ProfileUserNameC
import com.gzq.wanandroid.features.main.LocalLoginState
import com.gzq.wanandroid.router.Router
import com.gzq.wanandroid.ui.theme.AndroidTemplateTheme
import com.gzq.wanandroid.widget.OnDevelopingDialogC
import kotlinx.coroutines.launch


internal val CollapsedAppBarHeight = 56.dp
internal val ExpandedAppBarHeight = 270.dp
internal val ExpandedImageSize = 80.dp
internal val CollapsedImageSize = 36.dp
internal val ExpandedImageOffsetY = CollapsedAppBarHeight
internal val CollapsedImageOffsetY = (CollapsedAppBarHeight - CollapsedImageSize) / 2
internal val ExpandedImageOffsetX = 24.dp
internal val CollapsedImageOffsetX = 16.dp
internal val CollapsedOffsetY =
    ExpandedAppBarHeight - ExpandedImageOffsetY - ExpandedImageSize - 32.dp

internal val ExpandedTextLineHeight = 36.sp
internal val CollapsedTextSizeLineHeight = 20.sp
internal val ExpandedTextSize = 28.sp
internal val CollapsedTextSize = 16.sp

internal val ExpandedTextOffsetX = ExpandedImageOffsetX + ExpandedImageSize + ExpandedImageOffsetX
internal val CollapsedTextOffsetX =
    CollapsedImageOffsetX + CollapsedImageSize + 12.dp
internal val ExpandedTextOffsetY = ExpandedImageOffsetY + ExpandedImageSize / 2 - 36.dp / 2
internal val CollapsedTextOffsetY = CollapsedAppBarHeight / 2 - 20.dp / 2


fun NavGraphBuilder.profileMainPage(
    navController: NavHostController,
    loginController: (Boolean, Boolean) -> Unit,
    showBottomNavigationBar: (Boolean) -> Unit
) {
    composable(Router.ProfilePage.route) {
        ProfileMainPage(launchLoginPage = {
            showBottomNavigationBar(false)
            navController.navigate(Router.LoginPage.route)
        }, loginController = loginController,
            launchChangeLanguagePage = {
                navController.navigate(Router.ChangeLanguagePage.route)
            }, launchChangeThemePage = {
                navController.navigate(Router.ChangeThemePage.route)
            })
    }
}

@Composable
fun ProfileMainPage(
    modifier: Modifier = Modifier,
    viewModel: ProfileMainViewModel = viewModel(),
    launchLoginPage: () -> Unit,
    loginController: (Boolean, Boolean) -> Unit,
    launchChangeLanguagePage: () -> Unit,
    launchChangeThemePage: () -> Unit
) {
    MyBackHandler()


    var showLogoutDialog by rememberSaveable { mutableStateOf(false) }
    if (showLogoutDialog) {
        val scope = rememberCoroutineScope()
        LogoutDialogC(onDismiss = { showLogoutDialog = false }) {
            scope.launch {
                if (viewModel.logout()) {
                    showLogoutDialog = false
                    loginController(false, true)
                }
            }
        }
    }

    var showLoginWarningDialog by rememberSaveable { mutableStateOf(false) }
    if (showLoginWarningDialog) {
        LoginWarningDialogC(onDismiss = { showLoginWarningDialog = false }) {
            showLoginWarningDialog = false
            launchLoginPage()
        }
    }


    var showOnDevelopDialog by rememberSaveable { mutableStateOf(false) }
    if (showOnDevelopDialog) {
        OnDevelopingDialogC { showOnDevelopDialog = false }
    }

    val userInfo by viewModel.userInfo.observeAsState(null)

    val loginState = LocalLoginState.current
    if (loginState) {
        LaunchedEffect(Unit) {
            viewModel.fetchUserInfo()
        }
    }



    Box(modifier.fillMaxSize()) {

        val scroll = rememberScrollState(0)

        //渐变背景色
        GradientHeader()

        //用户积分等信息
        BaseUserInfo()

        //通知小铃铛
        Notification()

        //菜单
        MenuList(scroll, exitLogin = {
            showLogoutDialog = true
        }, checkUpdate = {
            if (!loginState) {
                showLoginWarningDialog = true
            } else {
                //TODO:检查更新
            }
        },
            launchChangeLanguagePage = launchChangeLanguagePage,
            launchChangeThemePage = launchChangeThemePage
        )

        //头像
        ProfileAvatarC(
            modifier = Modifier.then(
                if (!LocalLoginState.current)
                    Modifier.clickable(onClick = launchLoginPage,
                        indication = null,//禁止水波纹
                        interactionSource = remember { MutableInteractionSource() })
                else Modifier
            )
        ) { scroll.value }

        //用户名
        ProfileUserNameC(
            if (userInfo == null) stringResource(id = R.string.sign_in_up)
            else userInfo!!.nickname ?: ""
        ) { scroll.value }
    }
}

@Composable
fun BoxScope.Notification() {
    Box(
        modifier = Modifier
            .height(CollapsedAppBarHeight)
            .align(Alignment.TopEnd)
    ) {
        IconButton(onClick = { }, modifier = Modifier.align(Alignment.CenterEnd)) {
            Icon(imageVector = Icons.Default.Notifications, contentDescription = null)
        }
    }
}


@Composable
fun GradientHeader() {
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(ExpandedAppBarHeight)
            .background(
                Brush.verticalGradient(
                    listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.secondaryContainer
                    )
                )
            )
    )
}

@Composable
fun BaseUserInfo() {

    Card(
        modifier = Modifier.padding(
            top = ExpandedImageOffsetY + ExpandedImageSize + 16.dp,
            start = 24.dp,
            end = 24.dp
        ),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
    ) {
        Row(Modifier.height(80.dp)) {
            BaseUserInfoItem(labelId = R.string.collection, value = "4")
            BaseUserInfoItem(labelId = R.string.share, value = "1")
            BaseUserInfoItem(labelId = R.string.rewards_points, value = "541")
            BaseUserInfoItem(labelId = R.string.history, value = "41")
        }
    }
}

@Composable
fun RowScope.BaseUserInfoItem(@StringRes labelId: Int, value: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(6.dp)
            .fillMaxHeight()
            .weight(1.0f)
    ) {
        Text(
            text = value,
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = stringResource(id = labelId), maxLines = 1, overflow = TextOverflow.Ellipsis)
    }
}


@Composable
fun MenuList(
    scroll: ScrollState,
    exitLogin: () -> Unit,
    checkUpdate: () -> Unit,
    launchChangeLanguagePage: () -> Unit,
    launchChangeThemePage: () -> Unit
) {
    Column {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(CollapsedAppBarHeight)
        )
        Column(modifier = Modifier.verticalScroll(scroll)) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(ExpandedAppBarHeight - CollapsedAppBarHeight - 20.dp)
            )


            Surface(
                Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                color = MaterialTheme.colorScheme.surface,
                elevation = 8.dp
            ) {
                Column(Modifier.fillMaxWidth()) {
                    MenuNormal()
                    Spacer(modifier = Modifier.height(8.dp))
                    MenuSetup(launchChangeLanguagePage, launchChangeThemePage)
                    Spacer(modifier = Modifier.height(8.dp))
                    MenuAccount(exitLogin, checkUpdate)
                    //为了演示滑动效果，故意增高
                    Spacer(modifier = Modifier.height(200.dp))
                }
            }
        }
    }
}

@Composable
fun MenuNormal() {
    Column(
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.menu_normal),
            style = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.onSurface)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Card {
            ProfileMenuItemC(iconRes = R.drawable.icon_001, title = R.string.privacy_policy) {

            }
            ProfileMenuItemC(iconRes = R.drawable.icon_002, title = R.string.user_service) {

            }
            ProfileMenuItemC(
                iconRes = R.drawable.icon_004,
                title = R.string.open_source_libraries
            ) {

            }
        }
    }
}

@Composable
fun MenuSetup(launchChangeLanguagePage: () -> Unit, launchChangeThemePage: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.menu_settings),
            style = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.onSurface)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Card {
            ProfileMenuItemC(iconRes = R.drawable.icon_001, title = R.string.change_language) {
                launchChangeLanguagePage()
            }
            ProfileMenuItemC(iconRes = R.drawable.icon_002, title = R.string.change_theme) {
                launchChangeThemePage()
            }
        }
    }
}

@Composable
fun MenuAccount(exitLogin: () -> Unit, checkUpdate: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.menu_account),
            style = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.onSurface)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Card {
            if (LocalLoginState.current) {
                ProfileMenuItemC(
                    iconRes = R.drawable.icon_001,
                    title = R.string.sign_out,
                    onClick = exitLogin
                )
            }
            ProfileMenuItemC(
                iconRes = R.drawable.icon_002,
                title = R.string.check_update,
                onClick = checkUpdate
            )
        }
    }
}

@Preview
@Composable
fun PreviewProfileMainPage() {
    AndroidTemplateTheme {
        ProfileMainPage(launchLoginPage = { /*TODO*/ }, loginController = { login, show ->

        },
            launchChangeLanguagePage = {

            }, launchChangeThemePage = {
            })
    }
}

