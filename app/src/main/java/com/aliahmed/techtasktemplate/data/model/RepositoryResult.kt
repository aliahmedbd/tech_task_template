package com.aliahmed.techtasktemplate.data.model

sealed class RepositoryResult<out T> {
    data class Success<T>(val response: T) : RepositoryResult<T>()
    object Complete : RepositoryResult<Nothing>()

    sealed class Failed : RepositoryResult<Nothing>() {
        data class UnknownError(val message: String? = null) : Failed()
        data class Error(val exception: Throwable) : Failed()
        data class NetworkFailure(val code: Int? = null) : Failed()
    }
}