package com.itvo.pets.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.itvo.pets.presentation.screeen.PetScreen
import com.itvo.pets.ui.theme.PetsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PetsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Title(text = "Pets", modifier = Modifier.padding(innerPadding))
                    //PetList()

                    PetScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PetsTheme {
        Greeting("Android - Roma")
    }
}*/