package com.example.kepotekno.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Smartphone(
    val alamatToko: String? = null,
    val alamatTokoDua: String? = null,
    val brand: String? = null,
    val dimensi: String? = null,
    val gambar: String? = null,
    val harga: String? = null,
    val hargaOffline: String? = null,
    val hargaOnline: String? = null,
    val id: String? = null,
    val kapasitasBaterai: String? = null,
    val kategori: String? = null,
    val memoriInternal: String? = null,
    val nama: String? = null,
    val namaProduk: String? = null,
    val namaToko: String? = null,
    val namaTokoDua: String? = null,
    val network: String? = null,
    val nomerToko: String? = null,
    val nomerTokoDua: String? = null,
    val os: String? = null,
    val osVersion: String? = null,
    val ram: String? = null,
    val resolusiKamera: String? = null,
    val screenResolution: String? = null,
    val simSlots: String? = null,
    val ukuranLayar: String? = null,
    val gambarToko: String? = null,
    val gambarTokoDua: String? = null
): Parcelable