package com.example.kepotekno.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.kepotekno.R
import com.example.kepotekno.feature.detail.DetailLaptopActivity
import com.example.kepotekno.model.Laptop
import kotlinx.android.synthetic.main.item_laptop.view.*
import org.jetbrains.anko.startActivity

class LaptopAdapter(private val context: Context, private val laptop: List<Laptop>) :
    RecyclerView.Adapter<LaptopAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_laptop,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = laptop.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(laptop[position])
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(laptop: Laptop) {

            var imgUrl = laptop.gambar

            Glide.with(itemView)
                .load(imgUrl)
                .override(91, 121)
                .into(itemView.imgGambar)

            itemView.tvNamaHp.text = laptop.nama
            itemView.tvHargaHp.text = laptop.harga
            itemView.tvRamHp.text = ("Processor: " + laptop.processor)
            itemView.tvInformation.text = ("Penyimpanan: "+ laptop.kapasitasHdd)

            itemView.setOnClickListener {
                itemView.context.startActivity<DetailLaptopActivity>("data" to laptop)
            }
        }

    }
}