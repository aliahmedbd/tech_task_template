package com.aliahmed.techtasktemplate.data.network
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("Accounts")
    suspend fun getAccounts() : Response<String>
}