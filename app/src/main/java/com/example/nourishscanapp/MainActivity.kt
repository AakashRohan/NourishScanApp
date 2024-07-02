package com.example.nourishscanapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val productInfoText: TextView = findViewById(R.id.product_info_text)
        val errorText: TextView = findViewById(R.id.error_text)
        val updateButton: Button = findViewById(R.id.update_button)

        // Simulate an API response here for demonstration purposes
        val simulatedApiResponse = "{ \"productName\": \"Test Product\", \"error\": \"Simulated Error Message\" }"
        Log.d("MainActivity", "Simulated API response: $simulatedApiResponse")

        // Extracting data from the simulated API response
        val productName = "Test Product" // Extract this from the simulated API response
        val error: String? = "Simulated Error Message" // Extract this from the simulated API response

        // This block simulates updating the TextViews based on the API response
        updateButton.setOnClickListener {
            if (error != null) {
                errorText.text = getString(R.string.error, error)
                Log.d("MainActivity", "Error occurred: $error")
            } else {
                productInfoText.text = getString(R.string.product_info, productName)
                errorText.text = getString(R.string.error, "")
                Log.d("MainActivity", "Product info updated: $productName")
            }

            // Start ResultActivity
            val intent = Intent(this, ResultActivity::class.java).apply {
                putExtra("productInfo", productName)
                putExtra("errorMessage", error)
            }
            startActivity(intent)
        }
    }
}