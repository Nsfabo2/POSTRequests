package com.example.postrequests

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST


class APIInterface {
    @Headers("Content-Type: application/json")
    @POST("/test/")
    fun PostUsers(@Body data: UserItem): Call<UserItem?>?

    @Headers("Content-Type: application/json")
    @GET("/test/")
    fun GetUsers(): Call<Users?>?
}