package com.example.kepotekno.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.kepotekno.R
import com.example.kepotekno.feature.detail.DetailActivity
import com.example.kepotekno.model.Smartphone
import kotlinx.android.synthetic.main.item_home.view.*
import org.jetbrains.anko.startActivity

class HomeSmartphoneAdapter(private val context: Context, private val smartphones: List<Smartphone>) :
    RecyclerView.Adapter<HomeSmartphoneAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_home,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = 5

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(smartphones[position])
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(smartphone: Smartphone) {

            var imgUrl = smartphone.gambar

            Glide.with(itemView)
                .load(imgUrl)
                .into(itemView.imgGambar)

            itemView.tvNama.text = smartphone.nama

//            Log.d("data", "img-url : " + smartphone.nama)
        }

    }
}