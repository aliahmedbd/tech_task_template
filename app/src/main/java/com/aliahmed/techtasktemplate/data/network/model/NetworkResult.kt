package com.aliahmed.techtasktemplate.data.network.model

sealed class NetworkResult<out T : Any> {
    data class Success<out T : Any>(val code: Int, val data: Any?) : NetworkResult<T>()
    data class Error(val code: Int, val errorMsg: String?) : NetworkResult<String>()
    data class Exception(val e: Throwable) : NetworkResult<Nothing>()
}
// https://medium.com/@sribanavasi/best-practice-for-handling-api-calls-using-retrofit-in-android-studio-36fb5e53c08