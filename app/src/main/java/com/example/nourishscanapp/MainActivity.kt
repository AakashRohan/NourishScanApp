package com.example.nourishscanapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val updateButton: Button = findViewById(R.id.update_button)

        updateButton.setOnClickListener {
            // Launch BarcodeScannerActivity to scan the barcode
            val intent = Intent(this, BarcodeScannerActivity::class.java)
            startActivity(intent)
        }
    }
}