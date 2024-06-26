package com.example.nourishscanapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.journeyapps.barcodescanner.CaptureActivity
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions

class BarcodeScannerActivity : ComponentActivity() {

    private val barcodeLauncher = registerForActivityResult(ScanContract()) { result ->
        if (result.contents != null) {
            Log.d("BarcodeScannerActivity", "Barcode scanned: ${result.contents}")
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("BARCODE", result.contents)
            startActivity(intent)
            finish()
        } else {
            Log.d("BarcodeScannerActivity", "No barcode scanned")
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startBarcodeScanner()
    }

    private fun startBarcodeScanner() {
        val options = ScanOptions().apply {
            setPrompt("Scan a barcode")
            setBeepEnabled(true)
            setOrientationLocked(false)
            captureActivity = CaptureActivity::class.java
        }
        barcodeLauncher.launch(options)
    }
}