package com.unidad.ganadera.notario.module_app.remote.dto

data class CattleUnit(
    val apodo: String,
    val arete: String,
    val fallecido: Boolean,
    val madre: String,
    val nacimiento: DateType,
    val padre: String,
    val sexo: String
)
