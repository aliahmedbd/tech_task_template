package com.aliahmed.techtasktemplate.data.network.model

import com.aliahmed.techtasktemplate.data.model.RepositoryResult

fun<T,R> NetworkResult<T>.toRepositoryResult(mapper: (T) -> R) : RepositoryResult<R> = when(this) {
    is NetworkResult.Success -> RepositoryResult.Success(mapper(this.response))
    is NetworkResult.Error -> RepositoryResult.Failed.NetworkFailure(code)
    is NetworkResult.Exception -> RepositoryResult.Failed.Error(e)
}