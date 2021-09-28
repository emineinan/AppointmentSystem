package com.example.zonezerocase.data.service

import com.example.zonezerocase.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    abstract class RetrofitInstance {
        companion object {
            private val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            val retrofitInstance: RetrofitApi by lazy {
                retrofit.create(RetrofitApi::class.java)
            }
        }
    }
}