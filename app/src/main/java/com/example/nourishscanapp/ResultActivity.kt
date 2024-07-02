package com.example.nourishscanapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.nourishscanapp.ui.theme.NourishScanAppTheme

class ResultActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ResultActivity", "onCreate called")

        // Get the data from the intent
        val productInfo = intent.getStringExtra("productInfo") ?: "No Product Info"
        val errorMessage = intent.getStringExtra("errorMessage") ?: "No Error"

        setContent {
            NourishScanAppTheme {
                val resultViewModel: ResultViewModel = viewModel()

                // Update ViewModel with the data from the intent
                resultViewModel.updateProductInfo(productInfo)
                resultViewModel.updateErrorMessage(errorMessage)

                val productInfoState = resultViewModel.productInfo.observeAsState()
                val errorMessageState = resultViewModel.errorMessage.observeAsState()

                Log.d("ResultActivity", "Observing LiveData")

                ResultScreen(
                    productInfoState.value ?: "Product Info",
                    errorMessageState.value ?: "Error",
                    onUpdateClick = {
                        Log.d("ResultActivity", "Update button clicked")
                        resultViewModel.updateErrorMessage("Updated Error Message")
                    }
                )
            }
        }
    }
}

@Composable
fun ResultScreen(productInfo: String, errorMessage: String, onUpdateClick: () -> Unit) {
    Column {
        Text(text = "Product Info: $productInfo")
        Text(text = "Error: $errorMessage")
        Button(onClick = onUpdateClick) {
            Text(text = "UPDATE TEXT")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NourishScanAppTheme {
        ResultScreen("Product Info", "Error", onUpdateClick = {})
    }
}