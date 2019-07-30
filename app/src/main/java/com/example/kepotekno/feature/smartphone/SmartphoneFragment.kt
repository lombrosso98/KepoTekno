package com.example.kepotekno.feature.smartphone


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

import com.example.kepotekno.R
import com.example.kepotekno.adapter.SmartphoneAdapter
import com.example.kepotekno.model.Smartphone
import com.example.kepotekno.model.repository.RepoImpl
import com.example.kepotekno.network.ApiRest
import com.example.kepotekno.network.ApiService
import com.example.kepotekno.utils.invisible
import com.example.kepotekno.utils.visible
import kotlinx.android.synthetic.main.fragment_smartphone.*

class SmartphoneFragment : Fragment(), SmartphoneContract.View {

    private lateinit var presenter: SmartphonePresenter
    private var listSmartphone: MutableList<Smartphone> = mutableListOf()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter = SmartphonePresenter(this)
        presenter.getAllSmartphones()
    }

    override fun showLoading() {
        progressBar.visible()
        recyclerView.invisible()
    }

    override fun hideLoading() {
        progressBar.invisible()
        recyclerView.visible()
    }

    override fun showAllSmartphones(smartphones: MutableList<Smartphone>) {
        listSmartphone.clear()
        listSmartphone.addAll(smartphones)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = SmartphoneAdapter(requireContext(), listSmartphone)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_smartphone, container, false)
    }


}
