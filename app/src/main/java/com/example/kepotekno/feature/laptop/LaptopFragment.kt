package com.example.kepotekno.feature.laptop


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

import com.example.kepotekno.R
import com.example.kepotekno.adapter.LaptopAdapter
import com.example.kepotekno.model.Laptop
import com.example.kepotekno.model.repository.RepoImpl
import com.example.kepotekno.network.ApiRest
import com.example.kepotekno.network.ApiService
import com.example.kepotekno.utils.invisible
import com.example.kepotekno.utils.visible
import kotlinx.android.synthetic.main.fragment_laptop.*

class LaptopFragment : Fragment(), LaptopContract.View {

    private lateinit var presenter: LaptopPresenter
    private var listLaptop: MutableList<Laptop> = mutableListOf()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter = LaptopPresenter(this)
        presenter.getAllLaptop()
    }

    override fun showLoading() {
        progressBar.visible()
        recyclerView.invisible()
    }

    override fun hideLoading() {
        progressBar.invisible()
        recyclerView.visible()
    }

    override fun showAllLaptop(laptop: MutableList<Laptop>) {
        listLaptop.clear()
        listLaptop.addAll(laptop)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = LaptopAdapter(requireContext(), listLaptop)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_laptop, container, false)
    }


}
