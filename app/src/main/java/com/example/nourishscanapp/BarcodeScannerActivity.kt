package com.example.nourishscanapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.journeyapps.barcodescanner.CaptureActivity
import com.journeyapps.barcodescanner.ScanOptions
import com.journeyapps.barcodescanner.ScanContract
import com.example.nourishscanapp.ui.ResultActivity

class BarcodeScannerActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startBarcodeScanner()
    }

    private fun startBarcodeScanner() {
        val options = ScanOptions()
        options.setPrompt("Scan a barcode")
        options.setBeepEnabled(true)
        options.setOrientationLocked(false)
        options.captureActivity = CaptureActivity::class.java

        val barcodeLauncher = registerForActivityResult(ScanContract()) { result ->
            if (result.contents != null) {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("BARCODE", result.contents)
                startActivity(intent)
            } else {
                setResult(Activity.RESULT_CANCELED)
            }
            finish()
        }
        barcodeLauncher.launch(options)
    }
}