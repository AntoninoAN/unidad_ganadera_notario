package com.unidad.ganadera.notario.model

import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getAllCows(unidadGanadera: String): Flow<PresentationData>
}