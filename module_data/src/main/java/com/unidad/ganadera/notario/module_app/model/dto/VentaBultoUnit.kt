package com.unidad.ganadera.notario.module_app.model.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "venta_bulto_unit")
data class VentaBultoUnit(
    @PrimaryKey
    val id: String,
    val observaciones: String,
    val precio_bulto: Int,
    val unidades: String
)
