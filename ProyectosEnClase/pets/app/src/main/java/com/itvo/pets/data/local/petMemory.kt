package com.itvo.pets.data.local

import com.itvo.pets.R
import com.itvo.pets.domain.PetType
import com.itvo.pets.domain.petModel

object petMemory {
    fun getPets(): List<petModel> {
        val pets = listOf(
            petModel(
                name = "Firulais",
                description = "black dog",
                type = PetType.DOG,
                image = R.drawable.hot_dog
            ),
            petModel(
                name = "Michi-Gan",
                description = "Person whit from",
                type = PetType.CAT,
                image = R.drawable.cat
            ),
            petModel(
                name = "Big",
                description = "python",
                type = PetType.SNAKE,
                image = R.drawable.python
            )
        )
        return pets
    }
}