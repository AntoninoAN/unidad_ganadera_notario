package com.unidad.ganadera.notario.module_app.domain

import com.google.firebase.firestore.ktx.toObject
import com.unidad.ganadera.notario.module_app.model.Event
import com.unidad.ganadera.notario.module_app.model.dto.CattleUnit
import com.unidad.ganadera.notario.module_app.remote.cache.ReadContract
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect

class Repository(private val readContract: ReadContract) : UseCase {
    private val _state = MutableStateFlow<Event>(Event.Empty)
    override val state: StateFlow<Event>
        get() = _state

    /**
     * Get Snapshot can return cache data, or fail if Offline. Note 01/16/2024, assuming ONLY online.
     * This should expose the data wrapper for different use case scenarios, a stateflow
     * should expose back to the presentation layer, to wrap again in a presentation data
     * so UI reflect such change....
     *
     */
    override suspend fun getAllCows() {
        val case = readContract.getAllCows().collect { cowsCollection ->
            cowsCollection.get().addOnSuccessListener { cowsDocument ->
                cowsDocument.documents.map { cowUnit ->
                    cowUnit.toObject<CattleUnit>()
                }?.run {
                    _state.value = Event.Success(this)
                }
            }.addOnFailureListener {
                it.printStackTrace()
                _state.value = Event.Failure(it.message)
            }
        }
    }
}