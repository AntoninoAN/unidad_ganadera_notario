package com.unidad.ganadera.notario.module_connection.connectivity

import kotlinx.coroutines.flow.Flow

interface ConnectionManager {
    /**
     * Returns true if there is an active internet connection.
     */
    fun isOnline(): Boolean

    /**
     * Returns true if the current connection is metered (e.g. mobile data).
     */
    fun isMetered(): Boolean

    /**
     * Returns a Flow that emits the current [ConnectionState].
     */
    fun observeConnection(): Flow<ConnectionState>
}
