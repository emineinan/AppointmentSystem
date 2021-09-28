package com.example.zonezerocase.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class İmage(
    @SerializedName("url")
    val url: String
): Parcelable