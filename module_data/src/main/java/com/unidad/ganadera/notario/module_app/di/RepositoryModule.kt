package com.unidad.ganadera.notario.module_app.di

import android.content.Context
import androidx.room.Room
import com.unidad.ganadera.notario.module_app.model.database.CattleDatabase
import com.unidad.ganadera.notario.module_app.model.repository.CattleRepository
import com.unidad.ganadera.notario.module_app.model.repository.CattleRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideCattleDatabase(@ApplicationContext context: Context): CattleDatabase {
        return Room.databaseBuilder(
            context,
            CattleDatabase::class.java,
            "cattle.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideCattleRepository(database: CattleDatabase): CattleRepository {
        return CattleRepositoryImpl(database.cattleDao())
    }
}
