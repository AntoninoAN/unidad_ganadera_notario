package com.example.domain.data

sealed class UIState {
    data class Success<T>(val data: T): UIState()
    data class Failure(val reason: String): UIState()
    data object Loading: UIState()
}