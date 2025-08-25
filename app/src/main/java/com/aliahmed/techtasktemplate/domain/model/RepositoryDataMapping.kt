package com.aliahmed.techtasktemplate.domain.model

import com.aliahmed.techtasktemplate.data.model.RepositoryResult

fun <T> RepositoryResult<T>.toUseCaseResult(): UseCaseResult<T> = when (this) {
    is RepositoryResult.Success -> UseCaseResult.Success(response)
    RepositoryResult.Complete -> UseCaseResult.Completed
    is RepositoryResult.Failed.Error -> UseCaseResult.Fail.GenericError(exception)
    is RepositoryResult.Failed.NetworkFailure -> UseCaseResult.Fail.NoConnection
    is RepositoryResult.Failed.UnknownError -> UseCaseResult.Fail.Unknown()
}