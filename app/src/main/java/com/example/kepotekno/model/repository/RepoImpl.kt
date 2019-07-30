package com.example.kepotekno.model.repository

import com.example.kepotekno.model.KameraResponse
import com.example.kepotekno.model.LaptopResponse
import com.example.kepotekno.model.SmartphoneResponse
import com.example.kepotekno.network.ApiRest
import io.reactivex.Flowable

class RepoImpl(private val apiRest: ApiRest): Repo {
    override fun getAllLaptop(): Flowable<LaptopResponse> = apiRest.getAllLaptop()

    override fun getAllKamera(): Flowable<KameraResponse> = apiRest.getAllKamera()

    override fun geAllTablet(): Flowable<SmartphoneResponse> = apiRest.getAllTablet()

    override fun getAllSmartphone(): Flowable<SmartphoneResponse> = apiRest.getAllSmartphone()
}