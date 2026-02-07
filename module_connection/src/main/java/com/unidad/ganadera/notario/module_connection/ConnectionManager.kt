package com.unidad.ganadera.notario.module_connection

import kotlinx.coroutines.flow.Flow

interface ConnectionManager {
    /**
     * Returns true if there is an active internet connection.
     */
    fun isOnline(): Boolean

    /**
     * Returns a Flow that emits the current [ConnectionState].
     */
    fun observeConnection(): Flow<ConnectionState>
}
