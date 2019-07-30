package com.example.kepotekno.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Kamera(
    val alamatToko: String? = null,
    val alamatTokoDua: String? = null,
    val berat: String? = null,
    val brand: String? = null,
    val dimensi: String? = null,
    val gambar: String? = null,
    val gambarToko: String? = null,
    val gambarTokoDua: String? = null,
    val harga: String? = null,
    val hargaOffline: String? = null,
    val hargaOnline: String? = null,
    val id: String? = null,
    val iso: String? = null,
    val kategori: String? = null,
    val nama: String? = null,
    val namaProduk: String? = null,
    val namaToko: String? = null,
    val namaTokoDua: String? = null,
    val nomerToko: String? = null,
    val nomerTokoDua: String? = null,
    val resolusiKamera: String? = null,
    val resolusiVideo: String? = null,
    val tipeKamera: String? = null,
    val tipeSensor: String? = null,
    val ukuranSensor: String? = null,
    val usbPort: String? = null
): Parcelable