package com.example.kepotekno.feature.dslr

import com.example.kepotekno.model.Kamera

interface DslrContract {

    interface View {
        fun showLoading()
        fun hideLoading()
        fun showAllKamera(kamera: MutableList<Kamera>)
    }

    interface Presenter {
        fun getAllKamera()
    }
}