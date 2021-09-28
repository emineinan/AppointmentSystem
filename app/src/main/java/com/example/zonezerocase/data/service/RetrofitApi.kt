package com.example.zonezerocase.data.service

import com.example.zonezerocase.data.models.Doctors
import retrofit2.http.GET

interface RetrofitApi {
    @GET("android/doctors.json")
    suspend fun getDoctors(): Doctors
}
