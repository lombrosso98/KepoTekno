package com.example.kepotekno.model

import com.google.gson.annotations.SerializedName

data class SmartphoneResponse(
    @SerializedName("data")
    val `data`: List<Smartphone>
)