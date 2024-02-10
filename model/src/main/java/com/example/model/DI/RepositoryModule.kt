package com.example.model.DI

import com.example.model.local.SchoolDAO
import com.example.model.local.SchoolDB
import com.example.model.remote.SchoolService
import com.example.model.repository.IRepository
import com.example.model.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideRepository(service: SchoolService, schoolDAO: SchoolDAO): IRepository {
        return RepositoryImpl(service, schoolDAO)
    }
}