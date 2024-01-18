package com.unidad.ganadera.notario.module_app.domain

import com.unidad.ganadera.notario.module_app.model.Event
import kotlinx.coroutines.flow.StateFlow

/**
 * For now, I will just expose nullable to the presentation layer
 * either we have data or not.
 * Wrap the presentation layer from the correct nullable value.
 * For the way the 'listener' implementation, I need to expose a single
 * observable-field or return the listener to the presentation layer...
 */
interface UseCase {
    val state: StateFlow<Event>
    suspend fun getAllCows()
}