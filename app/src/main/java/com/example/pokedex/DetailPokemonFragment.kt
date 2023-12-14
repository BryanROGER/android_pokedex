package com.example.pokedex

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.pokedex.databinding.FragmentDetailPokemonBinding
import com.squareup.picasso.Picasso


class DetailPokemonFragment : Fragment() {

    val args: DetailPokemonFragmentArgs by navArgs()
    lateinit var binding: FragmentDetailPokemonBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailPokemonBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pokemon = args.pokemon
        binding.pokemon = pokemon

        Picasso.get().load(pokemon.urlImage).resize(1000,1000).into(binding.ivImage)


    }


}