package com.example.zonezerocase.data.models

import com.google.gson.annotations.SerializedName

data class Doctors(
    @SerializedName("doctors")
    val doctors: ArrayList<Doctor>
)