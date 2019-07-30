package com.example.kepotekno.feature.tablet


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

import com.example.kepotekno.R
import com.example.kepotekno.adapter.TabletAdapter
import com.example.kepotekno.model.Smartphone
import com.example.kepotekno.model.repository.RepoImpl
import com.example.kepotekno.network.ApiRest
import com.example.kepotekno.network.ApiService
import com.example.kepotekno.utils.invisible
import com.example.kepotekno.utils.visible
import kotlinx.android.synthetic.main.fragment_tablet.*


class TabletFragment : Fragment(), TabletContract.View {

    private lateinit var presenter: TabletPresenter
    private var listTablet: MutableList<Smartphone> = mutableListOf()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter = TabletPresenter(this)
        presenter.getAllTablet()
    }

    override fun showLoading() {
        progressBar.visible()
        recyclerView.invisible()
    }

    override fun hideLoading() {
        progressBar.invisible()
        recyclerView.visible()
    }

    override fun showAllTablet(tablet: MutableList<Smartphone>) {
        listTablet.clear()
        listTablet.addAll(tablet)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = TabletAdapter(requireContext(), listTablet)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tablet, container, false)
    }


}
