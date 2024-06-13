package com.example.nourishscanapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {
    private val _viewState = MutableStateFlow("Initial State")
    val viewState: StateFlow<String> = _viewState

    fun updateState(newState: String) {
        _viewState.value = newState
    }
}