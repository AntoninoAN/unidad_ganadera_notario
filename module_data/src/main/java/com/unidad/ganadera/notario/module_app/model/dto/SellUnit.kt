package com.unidad.ganadera.notario.module_app.model.dto

data class SellUnit(
    val fecha_venta: DateType,
    val ganado_arete: String,
    val id: String,
    val observaciones: String,
    val peso_venta: String,
    val precio_peso: String,
    val venta_bulto_id: String
)
