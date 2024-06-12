package com.example.nourishscanapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.Color
import com.example.nourishscanapp.ui.theme.NourishScanAppTheme

class ResultActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val barcode = intent.getStringExtra("BARCODE")
        setContent {
            NourishScanAppTheme {
                Surface {
                    DisplayResult(barcode)
                }
            }
        }
    }
}

@Composable
fun DisplayResult(barcode: String?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Product Detail",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Scanned Barcode: $barcode",
            color = Color.White,
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NourishScanAppTheme {
        DisplayResult("Sample Barcode")
    }
}