package com.gzq.wanandroid.repository

import com.gzq.wanandroid.repository.remote.NetHelper
import com.gzq.wanandroid.model.HomeList
import com.gzq.wanandroid.core.http.HttpResult
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import com.gzq.wanandroid.core.exception.Failure
import com.gzq.wanandroid.model.Article
import com.gzq.wanandroid.model.UserInfo
import com.gzq.wanandroid.model.UserShareList
import com.gzq.wanandroid.repository.local.RoomHelp
import timber.log.Timber

object MyRepository {

    suspend fun fetchHomeList(page: Int): Result<HomeList?> {
        return handleException { NetHelper.service.getHomeList(page) }
    }

    suspend fun loginWithPassword(username: String, password: String): Result<UserInfo?> {
        return handleException { NetHelper.service.loginWithPassword(username, password) }
    }

    suspend fun logout(): Result<Nothing?> {
        return handleException { NetHelper.service.logout() }
    }

    suspend fun register(
        username: String,
        password: String,
        rePassword: String
    ): Result<UserInfo?> {
        return handleException { NetHelper.service.register(username, password, rePassword) }
    }

    suspend fun fetchMyShare(page: Int): Result<UserShareList?> {
        return handleException { NetHelper.service.myShare(page) }
    }

    suspend fun fetchMyHistory(): Result<List<Article>?> {
        return try {
            Result.success(RoomHelp.db.articleDao().fetchAll())
        } catch (e: Throwable) {
            Result.failure(Failure.OtherError(e))
        }
    }

    /**
     * 异常处理，减少模板代码
     */
    @OptIn(ExperimentalContracts::class)
    private suspend inline fun <T> handleException(crossinline onSuccess: suspend () -> HttpResult<T?>): Result<T?> {
        contract {
            callsInPlace(onSuccess, InvocationKind.AT_MOST_ONCE)
        }
        return if (NetHelper.networkHandler.isNetworkAvailable()) {
            try {
                val httpResult = onSuccess()
                if (httpResult.isSuccess) {
                    Result.success(httpResult.data)
                } else {
                    Timber.d("错误信息：${httpResult.code},${httpResult.message}")
                    Result.failure(
                        Failure.ServerError(
                            code = httpResult.code,
                            msg = httpResult.message
                        )
                    )
                }
            } catch (e: Throwable) {
                //HttpException等错误会走这里
                Result.failure(Failure.OtherError(e))
            }
        } else {
            Result.failure(Failure.NetworkError)
        }
    }
}