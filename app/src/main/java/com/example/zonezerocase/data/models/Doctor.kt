package com.example.zonezerocase.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize()
data class Doctor(
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("image")
    val image: İmage,
    @SerializedName("user_status")
    val userStatus: String
): Parcelable