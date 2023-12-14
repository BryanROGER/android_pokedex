package com.example.pokedex

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.launch

class ListPokemonViewModel() :ViewModel() {

    var Pokemons = MutableLiveData<List<Pokemon>>()

    fun getPokemonList():MutableLiveData<List<Pokemon>>{
        viewModelScope.launch {
            Pokemons.value = PokemonService.PokemonApi.retrofitService.getAllPokemons()
        }
        return Pokemons
    }

    /*companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                // Get the Application object from extras
                val application =
                    checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])

                return ListPokemonViewModel(
                    AppDatabase.getInstance(application.applicationContext).pokemonDao()
                ) as T
            }
        }

    }*/



}