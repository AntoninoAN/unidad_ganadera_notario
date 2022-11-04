package com.unidad.ganadera.notario.module_app.remote.cache

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

class ReadContractImpl(/*private val readDomain: ReadDomain*/): ReadContract {

    private val dataManagerRead by lazy {
        RemoteDataManagerRead(Firebase.firestore)
    }

    override fun getAllCows(): Flow<CollectionReference> {
        return dataManagerRead(ReadActions.GET_ALL_COWS.actions)
    }

    override suspend fun getACowByArg(arg: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getAllBuy() {
        TODO("Not yet implemented")
    }

    override suspend fun getABuyByArg(arg: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getAllObservation() {
        TODO("Not yet implemented")
    }

    override suspend fun getAObservationByArg(arg: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getAllBirth() {
        TODO("Not yet implemented")
    }

    override suspend fun getABirthByArg(arg: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getAllPurchase() {
        TODO("Not yet implemented")
    }

    override suspend fun getAPurchaseByArg(arg: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getAllBulkPurchase() {
        TODO("Not yet implemented")
    }

    override suspend fun getABulkPurchaseByArg(arg: String) {
        TODO("Not yet implemented")
    }

    enum class ReadActions(var actions: String){
        GET_ALL_COWS("/unidad_ganadera_notario/unidad_sonia/ganados")
    }
}