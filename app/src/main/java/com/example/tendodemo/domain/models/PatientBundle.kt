package com.example.tendodemo.domain.models

data class PatientBundle(
    val entry: List<Entry> = emptyList(),
    val id: String? = null,
    val resourceType: String? = null,
    val timestamp: String? = null
)