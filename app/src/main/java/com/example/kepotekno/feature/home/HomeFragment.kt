package com.example.kepotekno.feature.home


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

import com.example.kepotekno.R
import com.example.kepotekno.adapter.HomeKameraAdapter
import com.example.kepotekno.adapter.HomeLaptopAdapter
import com.example.kepotekno.adapter.HomeSmartphoneAdapter
import com.example.kepotekno.model.Kamera
import com.example.kepotekno.model.Laptop
import com.example.kepotekno.model.Smartphone
import com.example.kepotekno.model.repository.RepoImpl
import com.example.kepotekno.network.ApiRest
import com.example.kepotekno.network.ApiService
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeContract.View {

    private lateinit var presenter: HomePresenter
    private var listSmartphone: MutableList<Smartphone> = mutableListOf()
    private var listTablet: MutableList<Smartphone> = mutableListOf()
    private var listLaptop: MutableList<Laptop> = mutableListOf()
    private var listKamera: MutableList<Kamera> = mutableListOf()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter = HomePresenter(this)
        presenter.getAllASmartphones()
        presenter.getAllTablets()
        presenter.getAllLaptops()
        presenter.getAllKamera()
    }

    override fun showSmartphone(smartphones: MutableList<Smartphone>) {
        listSmartphone.clear()
        listSmartphone.addAll(smartphones)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayout.HORIZONTAL, false)
        rvSmartphoneHome.layoutManager = linearLayoutManager
        rvSmartphoneHome.adapter = HomeSmartphoneAdapter(requireContext(), listSmartphone)
    }

    override fun showTablet(tablets: MutableList<Smartphone>) {
        listTablet.clear()
        listTablet.addAll(tablets)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayout.HORIZONTAL, false)
        rvTabletHome.layoutManager = linearLayoutManager
        rvTabletHome.adapter = HomeSmartphoneAdapter(requireContext(), listTablet)
    }

    override fun showLaptop(laptops: MutableList<Laptop>) {
        listLaptop.clear()
        listLaptop.addAll(laptops)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayout.HORIZONTAL, false)
        rvLaptopHome.layoutManager = linearLayoutManager
        rvLaptopHome.adapter = HomeLaptopAdapter(requireContext(), listLaptop)
    }

    override fun showKamera(kameras: MutableList<Kamera>) {
        listKamera.clear()
        listKamera.addAll(kameras)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayout.HORIZONTAL, false)
        rvKameraHome.layoutManager = linearLayoutManager
        rvKameraHome.adapter = HomeKameraAdapter(requireContext(), listKamera)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


}
