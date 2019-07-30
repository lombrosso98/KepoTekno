package com.example.kepotekno.model.repository

import com.example.kepotekno.model.KameraResponse
import com.example.kepotekno.model.LaptopResponse
import com.example.kepotekno.model.SmartphoneResponse
import io.reactivex.Flowable

interface Repo {

    fun getAllSmartphone(): Flowable<SmartphoneResponse>
    fun geAllTablet(): Flowable<SmartphoneResponse>
    fun getAllKamera(): Flowable<KameraResponse>
    fun getAllLaptop(): Flowable<LaptopResponse>
}