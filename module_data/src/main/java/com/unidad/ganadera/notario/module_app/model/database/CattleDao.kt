package com.unidad.ganadera.notario.module_app.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.unidad.ganadera.notario.module_app.model.dto.* // ktlint-disable no-wildcard-imports

@Dao
interface CattleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCattle(cattle: CattleUnit)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertObservation(observation: ObservationUnit)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertParicion(paricion: ParicionUnit)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPurchase(purchase: PurchaseUnit)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSell(sell: SellUnit)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVentaBulto(ventaBulto: VentaBultoUnit)

    @Query("SELECT * FROM cattle_unit")
    suspend fun getAllCattle(): List<CattleUnit>

    @Query("SELECT * FROM observation_unit")
    suspend fun getAllObservations(): List<ObservationUnit>

    @Query("SELECT * FROM paricion_unit")
    suspend fun getAllPariciones(): List<ParicionUnit>

    @Query("SELECT * FROM purchase_unit")
    suspend fun getAllPurchases(): List<PurchaseUnit>

    @Query("SELECT * FROM sell_unit")
    suspend fun getAllSells(): List<SellUnit>

    @Query("SELECT * FROM venta_bulto_unit")
    suspend fun getAllVentasBulto(): List<VentaBultoUnit>
}