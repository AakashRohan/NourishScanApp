package com.example.nourishscanapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

class ResultActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ResultScreen()
        }
    }
}

@Composable
fun ResultScreen(viewModel: ResultViewModel = viewModel()) {
    val sampleData by remember { mutableStateOf("Hello, Result!") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = sampleData)
        Button(onClick = { viewModel.setSampleData("Hello, ViewModel!") }) {
            Text(text = "Update Text")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResultPreview() {
    ResultScreen()
}