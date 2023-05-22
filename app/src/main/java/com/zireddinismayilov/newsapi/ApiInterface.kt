package com.zireddinismayilov.newsapi


import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("3c86374a-738d-4911-bf09-1dac9e9760e4")
    fun getdata(): Call<Results>
}