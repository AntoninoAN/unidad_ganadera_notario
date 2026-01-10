package com.unidad.ganadera.notario.module_app.model.dto

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sell_unit")
data class SellUnit(
    @PrimaryKey
    val id: String,
    @Embedded
    val fecha_venta: DateType,
    val ganado_arete: String,
    val observaciones: String,
    val peso_venta: String,
    val precio_peso: String,
    val venta_bulto_id: String
)
