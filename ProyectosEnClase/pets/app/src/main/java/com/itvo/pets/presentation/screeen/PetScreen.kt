package com.itvo.pets.presentation.screeen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.itvo.pets.data.local.petMemory
import com.itvo.pets.presentation.composable.PetList
import com.itvo.pets.presentation.composable.Title

@Composable
fun PetScreen(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize()) {
        Title("I lovePets")
        Spacer(Modifier.height(8.dp))
        PetList(petMemory.getPets())
    }
}