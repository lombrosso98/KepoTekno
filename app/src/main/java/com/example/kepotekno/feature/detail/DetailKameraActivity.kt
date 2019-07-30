package com.example.kepotekno.feature.detail

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.kepotekno.R
import com.example.kepotekno.model.Kamera
import kotlinx.android.synthetic.main.activity_detail_kamera.*

class DetailKameraActivity : AppCompatActivity() {

    private lateinit var kamera: Kamera

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_kamera)

        kamera = intent.getParcelableExtra("data")

        initData()

        btnTelf.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:" +kamera.nomerToko)
            startActivity(intent)
        }

        btnTelfDua.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:" +kamera.nomerToko)
            startActivity(intent)
        }
    }

    private fun initData() {
        Glide.with(this)
            .load(kamera.gambar)
            .into(imgGambar)
        tvNamaKamera.text = kamera.nama
        tvHargaKamera.text = kamera.harga
        tvHargaOnline.text = kamera.hargaOnline
        tvHargaOffline.text = kamera.hargaOffline
        tvKategori.text = kamera.kategori
        tvBrand.text = kamera.brand
        tvTipeKamera.text = kamera.namaProduk
        tvUkuranSensor.text = kamera.ukuranSensor
        tvResolusiKamera.text = kamera.resolusiKamera
        tvTipeSensor.text = kamera.tipeSensor
        tvIso.text = kamera.iso
        tvResolusiVideo.text = kamera.resolusiVideo
        tvUsbPort.text = kamera.usbPort
        tvDimensi.text = kamera.dimensi
        tvBerat.text = kamera.berat

        tvJudulToko.text = ("TOKO FISIK YANG MENUAL " + kamera.kategori + " "+ kamera.nama)

        // detail toko pertama
        tvNamaToko.text = kamera.namaToko
        tvAlamatToko.text = kamera.alamatToko
        tvNamaHpToko.text = kamera.nama
        tvHargaToko.text = kamera.harga
        Glide.with(this)
            .load(kamera.gambarToko)
            .into(imgToko)

        // detail toko kedua
        tvNamaTokoDua.text = kamera.namaTokoDua
        tvAlamatTokoDua.text = kamera.alamatTokoDua
        tvNamaHpTokoDua.text = kamera.nama
        tvHargaTokoDua.text = kamera.harga
        Glide.with(this)
                .load(kamera.gambarTokoDua)
                .into(imgTokoDua)

        Log.d("data", "toko : " + kamera.gambarToko)
    }
}
