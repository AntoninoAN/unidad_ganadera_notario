package com.example.domain.data

sealed class UIState<T> {
    data class Success<T>(val data: T): UIState<T>()
    data class Failure<T>(val reason: String): UIState<T>()
    data class Loading<T>(val loading: Boolean): UIState<T>()
    companion object {
        fun <T> success(data: T): UIState<T> = Success<T>(data)
        fun <T> failure(reason: String): UIState<T> = Failure(reason)
        fun <T> loading(isLoading: Boolean): UIState<T> = Loading(isLoading)
    }
}