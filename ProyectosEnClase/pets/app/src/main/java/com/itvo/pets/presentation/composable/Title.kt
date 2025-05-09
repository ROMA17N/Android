package com.itvo.pets.presentation.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Title(text: String, modifier: Modifier = Modifier) {
    Row(modifier.fillMaxWidth()) {
        Icon(
            imageVector = Icons.Filled.Favorite,
            contentDescription = "Favorite Icon",
            tint = Color.Blue
        )
        Spacer(modifier.width(8.dp))
        Text (
                text = text
                )
    }
}