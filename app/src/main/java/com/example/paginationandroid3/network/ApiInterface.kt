package com.example.paginationandroid3.network

import com.example.paginationandroid3.model.DataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {

    @GET("user")
    @Headers("app-id: 63205f848775ec39d0f1884c")
    suspend fun getDataFromApi(@Query("page") page: Int): Response<DataModel>
}