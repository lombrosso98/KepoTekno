package com.example.kepotekno.feature.home

import com.example.kepotekno.model.Kamera
import com.example.kepotekno.model.Laptop
import com.example.kepotekno.model.Smartphone

interface HomeContract {

    interface View {
        fun showSmartphone(smartphones: MutableList<Smartphone>)
        fun showTablet(tablets: MutableList<Smartphone>)
        fun showLaptop(laptops: MutableList<Laptop>)
        fun showKamera(kameras: MutableList<Kamera>)
    }

    interface Presenter {
        fun getAllASmartphones()
        fun getAllTablets()
        fun getAllLaptops()
        fun getAllKamera()
    }
}