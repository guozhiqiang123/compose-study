package com.gzq.wanandroid.features.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gzq.wanandroid.LocalKey
import com.gzq.wanandroid.core.base.BaseViewModel
import com.gzq.wanandroid.core.exception.Failure
import com.gzq.wanandroid.repository.MyRepository
import com.tencent.mmkv.MMKV
import kotlinx.coroutines.launch

sealed class RegisterState {
    data class ErrorInfo(val info: String) : RegisterState()
    object Success : RegisterState()
}

class RegisterViewModel : BaseViewModel() {
    private val _registerState = MutableLiveData<RegisterState?>(null)
    val registerState: LiveData<RegisterState?> = _registerState

    fun register(userName: String, password: String, rePassword: String) {
        if (userName.isEmpty()) {
            _registerState.value = RegisterState.ErrorInfo("用户名不能为空")
            return
        }
        if (password.isEmpty()) {
            _registerState.value = RegisterState.ErrorInfo("密码不能为空")
            return
        }
        if (password.length < 6) {
            _registerState.value = RegisterState.ErrorInfo("密码不能少于6个字符")
            return
        }
        if (password != rePassword) {
            _registerState.value = RegisterState.ErrorInfo("两次密码不一致")
            return
        }

        viewModelScope.launch {
            MyRepository.register(userName, password, rePassword)
                .onSuccess {
                    MMKV.defaultMMKV().encode(LocalKey.KEY_IS_LOGIN, true)
                    MMKV.defaultMMKV().encode(LocalKey.KEY_USER_INFO, it)
                    _registerState.value = RegisterState.Success
                }.onFailure {
                    var info: String = ""
                    when (it) {
                        is Failure.OtherError -> info = it.message ?: ""
                        is Failure.NetworkError -> info = "没有网络"
                        is Failure.ServerError -> info = it.msg ?: ""
                    }
                    _registerState.value = RegisterState.ErrorInfo(info)
                }
        }
    }
}