package com.aliahmed.techtasktemplate.domain.result

import com.aliahmed.techtasktemplate.data.repositories.result.RepositoryResult

fun <T> RepositoryResult<T>.toUseCaseResult(): UseCaseResult<T> = when (this) {
    is RepositoryResult.Success -> UseCaseResult.Success(response)
    RepositoryResult.Complete -> UseCaseResult.Completed
    is RepositoryResult.Failed.Error -> UseCaseResult.Fail.GenericError(exception)
    is RepositoryResult.Failed.NetworkFailure -> UseCaseResult.Fail.NoConnection
    is RepositoryResult.Failed.UnknownError -> UseCaseResult.Fail.Unknown()
}