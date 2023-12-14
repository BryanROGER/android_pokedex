package com.example.pokedex

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Stat(
    var HP:Int,
    var attack:Int,
    var defense: Int,
    @Json(name = "special_attack")
    var specialAttack:Int,
    @Json(name = "special_defense")
    var specialDefense:Int,
    var speed : Int
) : Parcelable
