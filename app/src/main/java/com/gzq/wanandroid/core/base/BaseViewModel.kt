package com.gzq.wanandroid.core.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    protected val _error = MutableLiveData<Throwable>()
    val error: LiveData<Throwable> = _error
}