package com.itvo.pets.domain

data class petModel(
    val name: String,
    val description: String,
    val type: PetType,
    val image: Int
)
