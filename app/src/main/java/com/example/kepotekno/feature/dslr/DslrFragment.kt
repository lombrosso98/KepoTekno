package com.example.kepotekno.feature.dslr


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

import com.example.kepotekno.R
import com.example.kepotekno.adapter.KameraAdapter
import com.example.kepotekno.model.Kamera
import com.example.kepotekno.model.repository.RepoImpl
import com.example.kepotekno.network.ApiRest
import com.example.kepotekno.network.ApiService
import com.example.kepotekno.utils.invisible
import com.example.kepotekno.utils.visible
import kotlinx.android.synthetic.main.fragment_dslr.*

class DslrFragment : Fragment(), DslrContract.View {

    private lateinit var presenter: DslrPresenter
    private var listKamera: MutableList<Kamera> = mutableListOf()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter = DslrPresenter(this)
        presenter.getAllKamera()
    }

    override fun showLoading() {
        progressBar.visible()
        recyclerView.invisible()
    }

    override fun hideLoading() {
        progressBar.invisible()
        recyclerView.visible()
    }

    override fun showAllKamera(kamera: MutableList<Kamera>) {
        listKamera.clear()
        listKamera.addAll(kamera)
        val linearLayoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = KameraAdapter(requireContext(), listKamera)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dslr, container, false)
    }


}
