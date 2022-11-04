package com.unidad.ganadera.notario.module_app.remote.cache

import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.flow.Flow

interface ReadContract {
    fun getAllCows(): Flow<CollectionReference>
    suspend fun getACowByArg(arg: String)
    suspend fun getAllBuy()
    suspend fun getABuyByArg(arg: String)
    suspend fun getAllObservation()
    suspend fun getAObservationByArg(arg: String)
    suspend fun getAllBirth()
    suspend fun getABirthByArg(arg: String)
    suspend fun getAllPurchase()
    suspend fun getAPurchaseByArg(arg: String)
    suspend fun getAllBulkPurchase()
    suspend fun getABulkPurchaseByArg(arg: String)
}