package com.example.model.DI

import com.example.model.remote.BASE_URL
import com.example.model.remote.SchoolService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {
    @Provides
    fun provideSchoolService(retrofit: Retrofit): SchoolService =
        retrofit.create(SchoolService::class.java)

    @Provides
    fun provideRetrofit(client: OkHttpClient,
                        converterFactory: Converter.Factory): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(converterFactory)
            .client(client)
            .build()

    @Provides
    fun provideOkhttpClient(): OkHttpClient =
        OkHttpClient.Builder().build()

    @Provides
    fun provideConverterFactory(): Converter.Factory =
        MoshiConverterFactory.create()

}