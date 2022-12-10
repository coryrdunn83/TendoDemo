package com.example.tendodemo.di

import com.example.tendodemo.data.repository.PatientRepositoryImpl
import com.example.tendodemo.domain.repository.PatientRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataModule {
    @Binds
    @Singleton
    abstract fun patientRepository(patientRepository: PatientRepositoryImpl): PatientRepository
}