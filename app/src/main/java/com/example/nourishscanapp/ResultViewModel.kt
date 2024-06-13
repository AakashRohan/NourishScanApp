package com.example.nourishscanapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResultViewModel : ViewModel() {
    private val _barcodeResult = MutableLiveData<String>()
    val barcodeResult: LiveData<String> = _barcodeResult

    fun setBarcodeResult(result: String) {
        _barcodeResult.value = result
    }

    fun setSampleData(data: String) {
        _barcodeResult.value = data
    }
}