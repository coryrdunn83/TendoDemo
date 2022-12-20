package com.example.tendodemo.di

import com.example.tendodemo.data.repository.TestPatientRepositoryImpl
import com.example.tendodemo.domain.repository.PatientRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class TestDataModule {
    @Binds
    @Singleton
    abstract fun patientRepository(patientRepository: TestPatientRepositoryImpl): PatientRepository
}