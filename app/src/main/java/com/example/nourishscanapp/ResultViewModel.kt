package com.example.nourishscanapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResultViewModel : ViewModel() {
    private val _barcodeResult = MutableLiveData<String>()
    val barcodeResult: LiveData<String> = _barcodeResult

    private val _productInfo = MutableLiveData<String>()
    val productInfo: LiveData<String> = _productInfo

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    init {
        Log.d("ResultViewModel", "ViewModel initialized")
    }

    fun setBarcodeResult(result: String) {
        _barcodeResult.value = result
    }

    fun setSampleData(data: String) {
        _barcodeResult.value = data
    }

    fun updateProductInfo(info: String) {
        _productInfo.value = info
    }

    fun updateErrorMessage(message: String) {
        Log.d("ResultViewModel", "Updating error message: $message")
        _errorMessage.value = message
    }
}