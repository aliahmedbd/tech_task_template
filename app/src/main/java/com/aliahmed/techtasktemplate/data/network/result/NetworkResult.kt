package com.aliahmed.techtasktemplate.data.network.result

sealed class NetworkResult<out T> {
    data class Success<out T>(val code: Int, val response: T) : NetworkResult<T>()
    data class Error(val code: Int, val errorMsg: String?) : NetworkResult<Nothing>()
    data class Exception(val e: Throwable) : NetworkResult<Nothing>()
}