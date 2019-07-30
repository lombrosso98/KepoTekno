package com.example.kepotekno.feature.detail

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.kepotekno.R
import com.example.kepotekno.model.Laptop
import kotlinx.android.synthetic.main.activity_detail_laptop.*

class DetailLaptopActivity : AppCompatActivity() {

    private lateinit var laptop: Laptop

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_laptop)

        laptop = intent.getParcelableExtra("data")

        initData()

        btnTelf.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:" +laptop.nomerToko)
            startActivity(intent)
        }

        btnTelf.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:" +laptop.nomerToko)
            startActivity(intent)
        }
    }

    private fun initData() {
        Glide.with(this)
            .load(laptop.gambar)
            .into(imgGambar)
        tvNamaLaptop.text = laptop.nama
        tvHargaLaptop.text = laptop.harga
        tvHargaOnline.text = laptop.hargaOnline
        tvHargaOffline.text = laptop.hargaOffline
        tvKategori.text = laptop.kategori
        tvUkuranLayar.text = laptop.ukuranLayar
        tvProcessor.text = laptop.namaProduk
        tvRam.text = laptop.ram
        tvKapasitasHDD.text = laptop.kapasitasHdd
        tvKartuGrafis.text = laptop.kartuGrafis
        tvBerat.text = laptop.berat

        tvJudulToko.text = ("TOKO FISIK YANG MENUAL " + laptop.kategori + " "+ laptop.nama)

        // detail toko pertama
        tvNamaToko.text = laptop.namaToko
        tvAlamatToko.text = laptop.alamatToko
        tvNamaHpToko.text = laptop.nama
        tvHargaToko.text = laptop.harga
        Glide.with(this)
            .load(laptop.gambarToko)
            .into(imgToko)

        // detail toko kedua
        tvNamaTokoDua.text = laptop.namaTokoDua
        tvAlamatTokoDua.text = laptop.alamatTokoDua
        tvNamaHpTokoDua.text = laptop.nama
        tvHargaTokoDua.text = laptop.harga
        Glide.with(this)
                .load(laptop.gambarTokoDua)
                .into(imgTokoDua)

        Log.d("data", "no-telf : " + laptop.nomerToko)

    }
}
