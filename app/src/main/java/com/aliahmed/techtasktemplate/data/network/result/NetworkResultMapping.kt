package com.aliahmed.techtasktemplate.data.network.result

import com.aliahmed.techtasktemplate.data.repositories.result.RepositoryResult

fun<T,R> NetworkResult<T>.toRepositoryResult(mapper: (T) -> R) : RepositoryResult<R> = when(this) {
    is NetworkResult.Success -> RepositoryResult.Success(mapper(this.response))
    is NetworkResult.Error -> RepositoryResult.Failed.NetworkFailure(code)
    is NetworkResult.Exception -> RepositoryResult.Failed.Error(e)
}