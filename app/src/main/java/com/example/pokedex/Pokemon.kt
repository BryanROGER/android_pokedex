package com.example.pokedex

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    var id: Int,
    var name: String,
    @Json(name = "image")
    var urlImage: String,
    var stats: Stat
) :Parcelable
