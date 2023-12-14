package com.example.pokedex

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pokedex.databinding.TemplatePokemonLineBinding
import com.squareup.picasso.Picasso

class PokemonAdapter(val pokemonList: List<Pokemon>, val listener: (pokemon :Pokemon) -> Unit) :Adapter<PokemonAdapter.PokemonVH>(){

    class PokemonVH(val binding: TemplatePokemonLineBinding):ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonVH {
        val binding = TemplatePokemonLineBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PokemonVH(binding)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: PokemonVH, position: Int) {
        holder.itemView.setOnClickListener{
            listener.invoke(pokemonList[position])
        }
        holder.binding.pokemon = pokemonList[position]
        Picasso.get().load(pokemonList[position].urlImage).resize(300,300).into(holder.binding.imageView)
    }

}