package com.unidad.ganadera.notario.module_app.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.unidad.ganadera.notario.module_app.model.converters.Converters
import com.unidad.ganadera.notario.module_app.model.dto.* // ktlint-disable no-wildcard-imports

@Database(
    entities = [
        CattleUnit::class,
        ObservationUnit::class,
        ParicionUnit::class,
        PurchaseUnit::class,
        SellUnit::class,
        VentaBultoUnit::class
    ],
    version = 1
)
@TypeConverters(Converters::class)

abstract class CattleDatabase : RoomDatabase() {
    abstract fun cattleDao(): CattleDao
}