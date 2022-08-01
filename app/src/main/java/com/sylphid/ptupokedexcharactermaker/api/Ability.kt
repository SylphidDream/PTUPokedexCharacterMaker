package com.sylphid.ptupokedexcharactermaker.api

data class Ability(
    val name: String,
    val frequency: String,
    val effect: String,
    val actionType: String? = null,
    val trigger: String? = null,
    val target: String? = null,
    val table: List<List<String>>? = null
)