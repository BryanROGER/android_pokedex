package com.example.pokedex

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    companion object{
        var BASE_URL ="https://pokebuildapi.fr/api/v1/"

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()

    }

    @GET("pokemon")
    suspend fun getAllPokemons():List<Pokemon>

    @GET("pokemon/{code}")
    suspend fun getPokemonById(@Path("code")id:Int)

    @GET("pokemon/{code}")
    suspend fun getPokemonsByName(@Path("code")name: String): List<Pokemon>?

    object PokemonApi{
        val retrofitService : PokemonService by lazy { retrofit.create(PokemonService::class.java) }
    }

}
