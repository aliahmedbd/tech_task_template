package com.aliahmed.techtasktemplate.data.network.model

import retrofit2.HttpException
import retrofit2.Response

suspend fun <T : Any> handleApi(
    execute: suspend () -> Response<T>,
): NetworkResult<T> {
    return try {
        val response = execute()
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) {
                NetworkResult.Success(response.code(), body)
            } else {
                NetworkResult.Error(response.code(), "Response body is null")
            }
        } else {
            val errMsg = response.errorBody()?.string()
            NetworkResult.Error(response.code(), errMsg ?: response.message())
        }
    } catch (e: HttpException) {
        NetworkResult.Error(e.code(), e.message())
    } catch (e: Throwable) {
        NetworkResult.Exception(e)
    }
}
