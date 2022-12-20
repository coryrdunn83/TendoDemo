package com.example.tendodemo.data.repository

import android.content.Context
import com.example.tendodemo.data.source.getJsonDataFromFile
import com.example.tendodemo.domain.models.*
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
import java.time.ZonedDateTime
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TestPatientRepositoryImpl @Inject constructor(
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
            val patientBundle = PatientBundle(
                resourceType = "Bundle",
                id = "123456",
                timestamp = ZonedDateTime.now().toString(),
                entry = listOf(
                    Entry(
                        resource = Resource(
                            resourceType = "Patient",
                            id = "123456",
                            active = true,
                            name = listOf(
                                Name(
                                    text = "Tendo Tenderson",
                                    family = "Tenderson",
                                    given = listOf(
                                        "Tendo"
                                    )
                                )
                            ),
                            contact = listOf(
                                Contact(
                                    system = "phone",
                                    value = "555-555-1234",
                                    use = "mobile"
                                ),
                                Contact(
                                    system = "email",
                                    value = "tendo@tendoco.com",
                                    use = "work"
                                )
                            ),
                            gender = "female",
                            birthDate = "1955-01-06",
                            address = listOf(
                                Addres(
                                    use = "home",
                                    line = listOf(
                                        "2222 Home Street"
                                    )
                                )
                            )
                        )
                    ),
                    Entry(
                        resource = Resource(
                            resourceType = "Doctor",
                            id = "123456",
                            name = listOf(
                                Name(
                                    family = "Careful",
                                    given = listOf(
                                        "Adam"
                                    )
                                )
                            )
                        )
                    ),
                    Entry(
                        resource = Resource(
                            resourceType = "Appointment",
                            id = "123456",
                            status = "finished",
                            type = listOf(
                                Type(
                                    text = "Endo visit"
                                )
                            ),
                            subject = Subject(
                                reference = "Patient/123456"
                            ),
                            actor = Actor(
                                reference = "Doctor/123456"
                            ),
                            period = Period(
                                start = "2021-04-02T11:30:00Z",
                                end = "2021-04-02T12:00:00Z"
                            )
                        )
                    ),
                    Entry(
                        resource = Resource(
                            resourceType = "Diagnosis",
                            id = "123456",
                            meta = Meta(
                                lastUpdated = "2021-04-02T11:51:03Z"
                            ),
                            status = "final",
                            code = Code(
                                coding = listOf(
                                    Coding(
                                        system = "http://h17.org/fhir/sid/icd-10",
                                        code = "E10-E14.9",
                                        name = "Diabetes without complications"
                                    )
                                )
                            ),
                            appointment = Appointment(
                                reference = "Appointment/123456"
                            ),
                        )
                    )
                )
            )

            _patientDataFlow.emit(patientBundle)
        } catch (error: Exception) {
            println("Error getting patient data")
        }
    }
}