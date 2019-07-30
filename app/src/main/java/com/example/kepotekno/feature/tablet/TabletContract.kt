package com.example.kepotekno.feature.tablet

import com.example.kepotekno.model.Smartphone

interface TabletContract {

    interface View {
        fun showLoading()
        fun hideLoading()
        fun showAllTablet(tablet: MutableList<Smartphone>)
    }

    interface Presenter {
        fun getAllTablet()
    }
}