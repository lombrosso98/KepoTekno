package com.example.kepotekno.feature.detail

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.kepotekno.R
import com.example.kepotekno.adapter.ViewPagerAdapter
import com.example.kepotekno.feature.InfoFragment
import com.example.kepotekno.feature.SpesifikasiFragment
import com.example.kepotekno.model.Smartphone
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var smartphoneData: Smartphone

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        smartphoneData = intent.getParcelableExtra("data")

        initData()

        btnTelf.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:" +smartphoneData.nomerToko)
            startActivity(intent)
        }

        btnTelfDua.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:" +smartphoneData.nomerToko)
            startActivity(intent)
        }
    }

    private fun initData() {
        Glide.with(this)
                .load(smartphoneData.gambar)
                .into(imgGambar)
        tvNamaHp.text = smartphoneData.nama
        tvHargaHp.text = smartphoneData.harga
        tvHargaOnline.text = smartphoneData.hargaOnline
        tvHargaOffline.text = smartphoneData.hargaOffline
        tvKategori.text = smartphoneData.kategori
        tvBrand.text = smartphoneData.brand
        tvNamaProduk.text = smartphoneData.namaProduk
        tvNetwork.text = smartphoneData.network
        tvDimensi.text = smartphoneData.dimensi
        tvSimSlots.text = smartphoneData.simSlots
        tvUkuranLayar.text = smartphoneData.ukuranLayar
        tvScreenResolution.text = smartphoneData.screenResolution
        tvOs.text = smartphoneData.os
        tvOsVersion.text = smartphoneData.osVersion
        tvRam.text = smartphoneData.ram
        tvMemoriInternal.text = smartphoneData.memoriInternal
        tvResolusiKamera.text = smartphoneData.resolusiKamera
        tvKapasitasBaterai.text = smartphoneData.kapasitasBaterai

        // detail toko pertama
        tvJudulToko.text = ("TOKO FISIK YANG MENJUAL " + smartphoneData.namaProduk)
        tvNamaToko.text = smartphoneData.namaToko
        tvAlamatToko.text = smartphoneData.alamatToko
        tvNamaHpToko.text = smartphoneData.nama
        tvHargaToko.text = smartphoneData.hargaOffline
        Glide.with(this)
                .load(smartphoneData.gambarToko)
                .into(imgToko)

        // detail toko kedua
        tvNamaTokoDua.text = smartphoneData.namaTokoDua
        tvAlamatTokoDua.text = smartphoneData.alamatTokoDua
        tvNamaHpTokoDua.text = smartphoneData.nama
        tvHargaTokoDua.text = smartphoneData.hargaOffline
        Glide.with(this)
                .load(smartphoneData.gambarTokoDua)
                .into(imgTokoDua)
    }
}
