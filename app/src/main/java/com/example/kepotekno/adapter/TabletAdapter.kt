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
import kotlinx.android.synthetic.main.item_smartphone.view.*
import org.jetbrains.anko.startActivity

class TabletAdapter(private val context: Context, private val smartphones: List<Smartphone>) :
    RecyclerView.Adapter<TabletAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_tablet,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = smartphones.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(smartphones[position])
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(smartphone: Smartphone) {

            var imgUrl = smartphone.gambar

            Glide.with(itemView)
                .load(imgUrl)
                .override(91, 121)
                .into(itemView.imgGambar)

            itemView.tvNamaHp.text = smartphone.nama
            itemView.tvHargaHp.text = smartphone.harga
            itemView.tvRamHp.text = ("OS: " + smartphone.os)
            itemView.tvInformation.text = ("RAM: "+smartphone.ram)


            Log.d("data", "img-url : " + smartphone.nama)

            itemView.setOnClickListener {
                itemView.context.startActivity<DetailActivity>("data" to smartphone)
            }
        }

    }
}