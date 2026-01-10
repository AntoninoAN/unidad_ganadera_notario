package com.unidad.ganadera.notario.module_app.model.repository

import com.unidad.ganadera.notario.module_app.model.database.CattleDao
import com.unidad.ganadera.notario.module_app.model.dto.* // ktlint-disable no-wildcard-imports

class CattleRepositoryImpl(private val cattleDao: CattleDao) : CattleRepository {
    override suspend fun insertCattle(cattle: CattleUnit) {
        cattleDao.insertCattle(cattle)
    }

    override suspend fun insertObservation(observation: ObservationUnit) {
        cattleDao.insertObservation(observation)
    }

    override suspend fun insertParicion(paricion: ParicionUnit) {
        cattleDao.insertParicion(paricion)
    }

    override suspend fun insertPurchase(purchase: PurchaseUnit) {
        cattleDao.insertPurchase(purchase)
    }

    override suspend fun insertSell(sell: SellUnit) {
        cattleDao.insertSell(sell)
    }

    override suspend fun insertVentaBulto(ventaBulto: VentaBultoUnit) {
        cattleDao.insertVentaBulto(ventaBulto)
    }

    override suspend fun getAllCattle(): List<CattleUnit> {
        return cattleDao.getAllCattle()
    }

    override suspend fun getAllObservations(): List<ObservationUnit> {
        return cattleDao.getAllObservations()
    }

    override suspend fun getAllPariciones(): List<ParicionUnit> {
        return cattleDao.getAllPariciones()
    }

    override suspend fun getAllPurchases(): List<PurchaseUnit> {
        return cattleDao.getAllPurchases()
    }

    override suspend fun getAllSells(): List<SellUnit> {
        return cattleDao.getAllSells()
    }

    override suspend fun getAllVentasBulto(): List<VentaBultoUnit> {
        return cattleDao.getAllVentasBulto()
    }
}