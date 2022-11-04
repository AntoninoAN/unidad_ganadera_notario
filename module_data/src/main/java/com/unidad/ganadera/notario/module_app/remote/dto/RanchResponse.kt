package com.unidad.ganadera.notario.module_app.remote.dto

data class PurchaseUnit(
    val apodo: String,
    val arete: String,
    val comentarios: String,
    val fecha_compra: DateType,
    val fecha_nacimiento: DateType,
    val id: String,
    val peso: Int,
    val precio: Int,
    val sexo: String
)
