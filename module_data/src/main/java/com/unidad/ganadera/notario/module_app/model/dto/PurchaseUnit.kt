package com.unidad.ganadera.notario.module_app.model.dto

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "purchase_unit")
data class PurchaseUnit(
    @PrimaryKey
    val id: String,
    val apodo: String,
    val arete: String,
    val comentarios: String,
    @Embedded(prefix = "fecha_compra_")
    val fecha_compra: DateType,
    @Embedded(prefix = "fecha_nacimiento_")
    val fecha_nacimiento: DateType,
    val peso: Int,
    val precio: Int,
    val sexo: String
)
