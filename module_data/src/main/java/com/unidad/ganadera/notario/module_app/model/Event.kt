package com.unidad.ganadera.notario.module_app.model

sealed interface Event{
    data class Success<T>(val data: T): Event
    data class Failure<T>(val error: T): Event
    object Empty: Event
}