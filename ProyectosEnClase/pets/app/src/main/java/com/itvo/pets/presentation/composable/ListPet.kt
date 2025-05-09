package com.itvo.pets.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.itvo.pets.R
import com.itvo.pets.domain.PetType
import com.itvo.pets.domain.petModel

@Composable
fun PetList(pets: List<petModel>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(pets) { pet ->
            Row(
                modifier
                    .fillMaxWidth()
                    .border(
                        width = 2.dp,
                        color = Color(3, 169, 244, 255),
                        shape = RoundedCornerShape(8.dp)

                    )
                    .padding(4.dp)
            ) {
                AsyncImage(
                    model = pet.image,
                    contentDescription = null, modifier
                        .width(75.dp)
                        .height(75.dp)
                )
                Spacer(modifier.width(8.dp))
                Text(
                    text = pet.name + " " + pet.description,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Spacer(modifier.height(4.dp))
        }
    }
}