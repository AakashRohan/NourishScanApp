package com.example.nourishscanapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ResultActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ResultScreen()
        }
    }
}

@Composable
fun ResultScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Scan Result") }
            )
        },
        content = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text("Scan result will be displayed here!")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ResultScreen()
}