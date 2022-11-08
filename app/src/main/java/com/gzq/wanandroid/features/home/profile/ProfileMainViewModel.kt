package com.gzq.wanandroid.features.home.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gzq.wanandroid.App
import com.gzq.wanandroid.LocalKey
import com.gzq.wanandroid.core.base.BaseViewModel
import com.gzq.wanandroid.model.UserInfo
import com.gzq.wanandroid.repository.MyRepository
import com.tencent.mmkv.MMKV
import kotlinx.coroutines.launch
import timber.log.Timber

class ProfileMainViewModel : BaseViewModel() {

    private val _userInfo = MutableLiveData<UserInfo?>()
    val userInfo: LiveData<UserInfo?> = _userInfo


    suspend fun logout(): Boolean {
        return MyRepository.logout().onSuccess {
            //清理本地数据
            MMKV.defaultMMKV().remove(LocalKey.KEY_IS_LOGIN)
            MMKV.defaultMMKV().remove(LocalKey.KEY_USER_INFO)
            _userInfo.value = null
        }.onFailure {
            Timber.e(it)
        }.isSuccess
    }

    fun fetchUserInfo() {
        _userInfo.value=MMKV.defaultMMKV().decodeParcelable(LocalKey.KEY_USER_INFO, UserInfo::class.java)
    }
}