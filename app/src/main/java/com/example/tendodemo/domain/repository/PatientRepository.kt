package com.example.tendodemo.domain.repository

import com.example.tendodemo.domain.models.PatientBundle
import kotlinx.coroutines.flow.StateFlow

interface PatientRepository {
    val patientDataFlow: StateFlow<PatientBundle?>

    suspend fun getPatientData()
}