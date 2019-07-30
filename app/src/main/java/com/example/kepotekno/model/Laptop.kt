package com.example.kepotekno.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Laptop(
    val alamatToko: String? = null,
    val alamatTokoDua: String? = null,
    val berat: String? = null,
    val gambar: String? = null,
    val gambarToko: String? = null,
    val gambarTokoDua: String? = null,
    val harga: String? = null,
    val hargaOffline: String? = null,
    val hargaOnline: String? = null,
    val id: String? = null,
    val kapasitasHdd: String? = null,
    val kartuGrafis: String? = null,
    val kategori: String? = null,
    val nama: String? = null,
    val namaProduk: String? = null,
    val namaToko: String? = null,
    val namaTokoDua: String? = null,
    val nomerToko: String? = null,
    val nomerTokoDua: String? = null,
    val processor: String? = null,
    val ram: String? = null,
    val ukuranLayar: String? = null
): Parcelable