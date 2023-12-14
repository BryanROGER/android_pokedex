package com.example.pokedex

import com.squareup.picasso.Picasso

class PicassoService {

    companion object{
        fun loadImage(url :String){
            Picasso.get().load(url)
        }
    }

}