package com.sylphid.ptupokedexcharactermaker.api

import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

private val TAG = "PTUService"
class PTUService {

    private val firestore = Firebase.firestore

    suspend fun getAbilities(){
        var abilities = mutableListOf<Ability>()
        firestore.collection("abilities")
            .get()
            .addOnSuccessListener { documents ->
                for(document in documents){
                    abilities.add(document.toObject<Ability>())
                }
            }
            .addOnFailureListener {
                Log.w(TAG, "getAbilities: ${it.message}", it )
            }
    }

//    suspend fun getPokemon(){
//        var pokemon = mutableListOf<Pokemon>()
//        firestore.collection("pokemon")
//            .get()
//            .addOnSuccessListener { documents ->
//                for(document in documents){
//                    pokemon.add(document.toObject<Pokemon>())
//                }
//            }
//    }
}