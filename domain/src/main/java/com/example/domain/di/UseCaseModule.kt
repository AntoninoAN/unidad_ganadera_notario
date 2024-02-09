package com.example.domain.di

import com.example.domain.DetailedSchoolWithSatUseCase
import com.example.domain.FetchSchoolWithSatListUseCase
import com.example.model.repository.IRepository
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun provideDetailedUseCase(repository: IRepository) = DetailedSchoolWithSatUseCase(repository)
    @Provides
    fun provideFetchUseCase(repository: IRepository) = FetchSchoolWithSatListUseCase(repository)
}