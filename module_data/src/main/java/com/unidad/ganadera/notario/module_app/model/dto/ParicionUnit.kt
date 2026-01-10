package com.unidad.ganadera.notario.module_app.model.dto

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "paricion_unit")
data class ParicionUnit(
    @PrimaryKey
    val arete: String,
    @Embedded
    val fecha: DateType,
    val madre: String,
    val padre: String,
    val sexo: String,
    val vivo: Boolean
)
