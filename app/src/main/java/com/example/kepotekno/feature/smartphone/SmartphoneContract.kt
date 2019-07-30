package com.example.kepotekno.feature.smartphone

import com.example.kepotekno.model.Smartphone

interface SmartphoneContract {

    interface View {
        fun showLoading()
        fun hideLoading()
        fun showAllSmartphones(smartphones: MutableList<Smartphone>)
    }

    interface Presenter {
        fun getAllSmartphones()
    }
}