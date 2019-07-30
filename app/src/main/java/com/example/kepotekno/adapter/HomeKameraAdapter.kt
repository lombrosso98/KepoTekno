package com.example.kepotekno.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.kepotekno.R
import com.example.kepotekno.feature.detail.DetailKameraActivity
import com.example.kepotekno.model.Kamera
import kotlinx.android.synthetic.main.item_home.view.*
import org.jetbrains.anko.startActivity

class HomeKameraAdapter(private val context: Context, private val kamera: List<Kamera>) :
    RecyclerView.Adapter<HomeKameraAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_home,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = kamera.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(kamera[position])
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(kamera: Kamera) {

            var imgUrl = kamera.gambar

            Glide.with(itemView)
                .load(imgUrl)
                .override(91, 121)
                .into(itemView.imgGambar)

            itemView.tvNama.text = kamera.nama

        }

    }
}