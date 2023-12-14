package com.example.pokedex

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex.databinding.FragmentListPokemonBinding


class ListPokemonFragment : Fragment() {

    lateinit var vm : ListPokemonViewModel
    lateinit var binding : FragmentListPokemonBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListPokemonBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm = ViewModelProvider(this)[ListPokemonViewModel::class.java]
        val recycler = binding.recyclerPokemon


//        Picasso.get().load(vm.getPokemonList().value!!.get(1).urlImage).into(binding.)


        vm.getPokemonList().observe(viewLifecycleOwner){
            recycler.adapter = PokemonAdapter(it){
                val direction = ListPokemonFragmentDirections.ListToDetail(it)
                Navigation.findNavController(view).navigate(direction)
            }
            recycler.layoutManager = LinearLayoutManager(context)
        }
    }



}