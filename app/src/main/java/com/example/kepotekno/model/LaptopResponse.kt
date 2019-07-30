package com.example.kepotekno.model

import com.google.gson.annotations.SerializedName

data class LaptopResponse(
    @SerializedName("data")
    val `data`: List<Laptop>
)