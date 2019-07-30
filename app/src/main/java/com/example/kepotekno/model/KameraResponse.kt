package com.example.kepotekno.model

import com.google.gson.annotations.SerializedName

data class KameraResponse(
    @SerializedName("data")
    val `data`: List<Kamera>
)