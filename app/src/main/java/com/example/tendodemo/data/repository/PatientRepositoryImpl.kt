package com.example.tendodemo.data.repository

import android.content.Context
import com.example.tendodemo.data.source.getJsonDataFromFile
import com.example.tendodemo.domain.models.PatientBundle
import com.example.tendodemo.domain.repository.PatientRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PatientRepositoryImpl @Inject constructor(
    @ApplicationContext private val applicationContext: Context
): PatientRepository {
    private val scope = CoroutineScope(Job() + Dispatchers.IO)

    private val _patientDataFlow = MutableStateFlow<PatientBundle?>(null)
    override val patientDataFlow: StateFlow<PatientBundle?> = _patientDataFlow

    init {
        scope.launch {
            getPatientData()
        }
    }

    override suspend fun getPatientData() {
        try {
            val jsonFileString = getJsonDataFromFile(applicationContext, "patient-feedback-raw-data.json")

            val gson = Gson()
            val patientBundleType = object : TypeToken<PatientBundle>() {}.type
            val patientBundle: PatientBundle = gson.fromJson(jsonFileString, patientBundleType)

            _patientDataFlow.emit(patientBundle)
        } catch (error: Exception) {
            println("Error getting patient data")
        }
    }
}