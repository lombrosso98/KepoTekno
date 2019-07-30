package com.example.kepotekno.network

import com.example.kepotekno.model.KameraResponse
import com.example.kepotekno.model.LaptopResponse
import com.example.kepotekno.model.SmartphoneResponse
import io.reactivex.Flowable
import retrofit2.http.GET

interface ApiRest {

    @GET("smartphone.php")
    fun getAllSmartphone(): Flowable<SmartphoneResponse>

    @GET("tablet.php")
    fun getAllTablet(): Flowable<SmartphoneResponse>

    @GET("kamera.php")
    fun getAllKamera(): Flowable<KameraResponse>

    @GET("laptop.php")
    fun getAllLaptop(): Flowable<LaptopResponse>
}