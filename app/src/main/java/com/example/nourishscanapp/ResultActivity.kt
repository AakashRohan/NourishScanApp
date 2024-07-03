package com.example.nourishscanapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val barcodeData = intent.getStringExtra("BARCODE")
        Log.d("ResultActivity", "Received barcode data: $barcodeData")

        setContent {
            ResultScreen(barcodeData)
        }
    }
}

@Composable
fun ResultScreen(barcodeData: String?, viewModel: ResultViewModel = viewModel()) {
    val data = barcodeData ?: "No data received"
    val productInfo = remember { mutableStateOf("Fetching product info...") }
    val errorMessage = remember { mutableStateOf("") }

    LaunchedEffect(data) {
        val apiService = ApiClient.retrofit.create(ApiService::class.java)
        val call = apiService.getProductInfo(data)

        call.enqueue(object : Callback<ProductResponse> {
            override fun onResponse(call: Call<ProductResponse>, response: Response<ProductResponse>) {
                if (response.isSuccessful) {
                    val product = response.body()?.products?.firstOrNull()
                    productInfo.value = product?.product_name ?: "No product info found"
                } else {
                    productInfo.value = "Failed to fetch product info"
                    errorMessage.value = "Error: ${response.errorBody()?.string()}"
                }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                productInfo.value = "Error: ${t.message}"
                errorMessage.value = "Error: ${t.message}"
            }
        })
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = productInfo.value)
        if (errorMessage.value.isNotEmpty()) {
            Text(text = errorMessage.value, color = Color.Red)
        }
        Button(onClick = { viewModel.setSampleData("Hello, ViewModel!") }) {
            Text(text = "Update Text")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResultPreview() {
    ResultScreen(barcodeData = "Sample Barcode Data")
}