package com.example.kepotekno.feature.laptop

import com.example.kepotekno.model.Laptop

interface LaptopContract {

    interface View {
        fun showLoading()
        fun hideLoading()
        fun showAllLaptop(laptop: MutableList<Laptop>)
    }

    interface Presenter {
        fun getAllLaptop()
    }
}