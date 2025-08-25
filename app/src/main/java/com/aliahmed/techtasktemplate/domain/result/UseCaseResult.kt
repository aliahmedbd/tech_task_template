package com.aliahmed.techtasktemplate.domain.result

sealed class UseCaseResult<out T> {
    data class Success<T>(val data: T) : UseCaseResult<T>()
    data object Completed : UseCaseResult<Nothing>()

    sealed class Fail : UseCaseResult<Nothing>() {
        data object NoConnection : Fail()
        data class Unknown(val responseCode: Int = -1) : Fail()
        data object SessionExpired : Fail()
        data class GenericError(val exception: Throwable): Fail()
    }
}