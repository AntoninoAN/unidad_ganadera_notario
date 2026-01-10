package com.unidad.ganadera.notario.module_app.model.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "observation_unit")
data class ObservationUnit(
    @PrimaryKey
    val id: String,
    val descripcion: String,
    val referencia_id: String
)
