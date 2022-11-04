package com.unidad.ganadera.notario.module_app.remote.cache

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class RemoteDataManagerRead(private val fireStore: FirebaseFirestore) {

    operator fun invoke(fireStoreRef: String): Flow<CollectionReference> {
        if (fireStore == null) throw Exception("Incorrect FireStore init")

        return flow { emit(fireStore.collection(fireStoreRef)) }
    }
}