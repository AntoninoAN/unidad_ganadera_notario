package com.unidad.ganadera.notario.module_app.remote.dto

data class ParicionUnit(
    val arete: String,
    val fecha: DateType,
    val madre: String,
    val padre: String,
    val sexo: String,
    val vivo: Boolean
)
