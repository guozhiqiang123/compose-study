package com.gzq.wanandroid.features.login

import androidx.compose.runtime.Stable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gzq.wanandroid.LocalKey
import com.gzq.wanandroid.core.base.BaseViewModel
import com.gzq.wanandroid.core.exception.Failure
import com.gzq.wanandroid.repository.MyRepository
import com.tencent.mmkv.MMKV
import kotlinx.coroutines.launch
import timber.log.Timber

@Stable
data class LoginSnackInfo(val type: Int, val msg: String) {
    companion object {
        const val NotSelectProtocol = 1
        const val UserNameEmpty = 2
        const val PasswordEmpty = 3
        const val WrongNameOrPassword = 4
        const val OtherError = 5
        const val Success = 6
    }
}

class LoginViewModel : BaseViewModel() {


    private val _showInfo = MutableLiveData<LoginSnackInfo?>()
    val showInfo: LiveData<LoginSnackInfo?> = _showInfo

    fun tryLogin(selectProtocol: Boolean, name: String, pwd: String) {
        if (!selectProtocol) {
            _showInfo.value = LoginSnackInfo(type = LoginSnackInfo.NotSelectProtocol, "请勾选协议")
            return
        }

        if (name.isEmpty()) {
            _showInfo.value = LoginSnackInfo(type = LoginSnackInfo.UserNameEmpty, "用户名为空")
            return
        }

        if (pwd.isEmpty()) {
            _showInfo.value = LoginSnackInfo(type = LoginSnackInfo.PasswordEmpty, "密码为空")
            return
        }

        viewModelScope.launch {
            MyRepository.loginWithPassword(name, pwd).onSuccess {
                Timber.d("登录信息：$it")
                _showInfo.value = LoginSnackInfo(type = LoginSnackInfo.Success, "登录成功")
                MMKV.defaultMMKV().encode(LocalKey.KEY_IS_LOGIN,true)
                MMKV.defaultMMKV().encode(LocalKey.KEY_USER_INFO,it)
            }.onFailure {
                when (it) {
                    is Failure.ServerError -> {
                        _showInfo.value =
                            LoginSnackInfo(
                                type = LoginSnackInfo.WrongNameOrPassword,
                                msg = it.msg ?: "未知错误"
                            )
                    }

                    is Failure.OtherError -> {
                        _showInfo.value =
                            LoginSnackInfo(
                                type = LoginSnackInfo.WrongNameOrPassword,
                                msg = it.message ?: "未知错误"
                            )
                    }

                    is Failure.NetworkError -> {
                        _showInfo.value =
                            LoginSnackInfo(
                                type = LoginSnackInfo.WrongNameOrPassword,
                                msg = "没有网络"
                            )
                    }

                    is Failure.EmptyData -> {
                        _showInfo.value =
                            LoginSnackInfo(
                                type = LoginSnackInfo.WrongNameOrPassword,
                                msg = "空数据"
                            )
                    }

                    else -> {
                        Timber.e(it)
                    }
                }
            }
        }
    }
}