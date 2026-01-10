package com.unidad.ganadera.notario.module_app.model.dto

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cattle_unit")
data class CattleUnit(
    @PrimaryKey
    val arete: String,
    val apodo: String,
    val fallecido: Boolean,
    val madre: String,
    @Embedded
    val nacimiento: DateType,
    val padre: String,
    val sexo: String
)
