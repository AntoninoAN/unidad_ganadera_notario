package com.unidad.ganadera.notario.module_app.domain

import com.unidad.ganadera.notario.module_app.remote.cache.ReadContract
import kotlinx.coroutines.flow.collect

class Repository(private val readContract: ReadContract): UseCase {
    /**
     * Get Snapshot can return cache data, or fail if Offline.
     */
    override suspend fun getAllCows() {
        val case = readContract.getAllCows().collect {
            it.get().addOnSuccessListener {query->
                query.documents
            }.addOnFailureListener {
                // todo log the Failure
            }
        }
    }
}