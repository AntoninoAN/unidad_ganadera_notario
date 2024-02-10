package com.example.model.DI

import android.content.Context
import com.example.model.local.SchoolDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomDBModule {
    @Singleton
    @Provides
    fun provideSchoolDB(
        @ApplicationContext app: Context
    ) = SchoolDB.getSchoolInstance(app)

    @Singleton
    @Provides
    fun provideSchoolDAO(schoolDB: SchoolDB) = schoolDB.getDao()
}
