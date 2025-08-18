package com.aliahmed.techtasktemplate.data.network.model

import retrofit2.HttpException
import retrofit2.Response

interface ApiHandler {
    suspend fun <T : Any> handleApi(
        execute: suspend () -> Response<T>
    ): NetworkResult<T> {
        try {
            val response = execute()

            if (response.isSuccessful) {
                return NetworkResult.Success(response.code(), response.body()!!)
            } else {
                return NetworkResult.Error(response.code(), response.errorBody()?.string())
            }
        } catch (e: HttpException) {
            NetworkResult.Error(e.code(), e.message())
        } catch (e: Throwable) {
            NetworkResult.Exception(e)
        }
    }
}