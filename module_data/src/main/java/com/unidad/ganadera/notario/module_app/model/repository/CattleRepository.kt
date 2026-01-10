package com.unidad.ganadera.notario.module_app.model.repository

import com.unidad.ganadera.notario.module_app.model.dto.* // ktlint-disable no-wildcard-imports

interface CattleRepository {
    suspend fun insertCattle(cattle: CattleUnit)
    suspend fun insertObservation(observation: ObservationUnit)
    suspend fun insertParicion(paricion: ParicionUnit)
    suspend fun insertPurchase(purchase: PurchaseUnit)
    suspend fun insertSell(sell: SellUnit)
    suspend fun insertVentaBulto(ventaBulto: VentaBultoUnit)

    suspend fun getAllCattle(): List<CattleUnit>
    suspend fun getAllObservations(): List<ObservationUnit>
    suspend fun getAllPariciones(): List<ParicionUnit>
    suspend fun getAllPurchases(): List<PurchaseUnit>
    suspend fun getAllSells(): List<SellUnit>
    suspend fun getAllVentasBulto(): List<VentaBultoUnit>
}