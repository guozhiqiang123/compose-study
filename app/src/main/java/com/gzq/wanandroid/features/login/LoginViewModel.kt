package com.gzq.wanandroid.features.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gzq.wanandroid.LocalKey
import com.gzq.wanandroid.core.base.BaseViewModel
import com.gzq.wanandroid.core.exception.Failure
import com.gzq.wanandroid.repository.MyRepository
import com.tencent.mmkv.MMKV
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber

sealed class LoginState {
    data class Error(val type: Int, val info: String) : LoginState() {
        companion object {
            const val NotSelectProtocol = 1
            const val UserNameEmpty = 2
            const val PasswordEmpty = 3
            const val WrongNameOrPassword = 4
            const val NoNetWork = 5
            const val OtherError = 6
        }
    }

    object Success : LoginState()
}

class LoginViewModel : BaseViewModel() {


    private val _loginState = MutableLiveData<LoginState?>()
    val loginState: LiveData<LoginState?> = _loginState

    //之所以没有把loading状态归类到login状态中，是因为livedata会遗漏数据
    private val _loadingState = MutableLiveData(false)
    val loadingState: LiveData<Boolean> = _loadingState

    fun tryLogin(selectProtocol: Boolean, name: String, pwd: String) {
        if (!selectProtocol) {
            _loginState.value =
                LoginState.Error(LoginState.Error.NotSelectProtocol, "请勾选协议")
            return
        }

        if (name.isEmpty()) {
            _loginState.value =
                LoginState.Error(LoginState.Error.UserNameEmpty, "用户名为空")
            return
        }

        if (pwd.isEmpty()) {
            _loginState.value =
                LoginState.Error(LoginState.Error.PasswordEmpty, "密码为空")
            return
        }

        _loadingState.value = true

        viewModelScope.launch {
            delay(10000)
            _loadingState.value = false
        }

        viewModelScope.launch {
            MyRepository.loginWithPassword(name, pwd).onSuccess {
                Timber.d("登录信息：$it")
                _loginState.value = LoginState.Success

                MMKV.defaultMMKV().encode(LocalKey.KEY_IS_LOGIN, true)
                MMKV.defaultMMKV().encode(LocalKey.KEY_USER_INFO, it)
            }.onFailure {
                _loadingState.value = false
                when (it) {
                    is Failure.ServerError -> {
                        _loginState.value =
                            LoginState.Error(
                                LoginState.Error.WrongNameOrPassword,
                                it.msg ?: "未知错误"
                            )
                    }

                    is Failure.OtherError -> {
                        _loginState.value =
                            LoginState.Error(
                                LoginState.Error.WrongNameOrPassword,
                                it.message ?: "未知错误"
                            )
                    }

                    is Failure.NetworkError -> {
                        _loginState.value =
                            LoginState.Error(
                                LoginState.Error.NoNetWork,
                                "没有网络"
                            )
                    }

                    is Failure.EmptyData -> {
                        _loginState.value =
                            LoginState.Error(
                                LoginState.Error.OtherError,
                                "空数据"
                            )
                    }

                    else -> {
                        Timber.e(it)
                    }
                }
            }
        }
    }

    fun updateLoadingState(show: Boolean) {
        _loadingState.value = show
    }
}