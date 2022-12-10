package com.example.tendodemo.domain.models

data class PatientBundle(
    val entry: List<Entry>,
    val id: String,
    val resourceType: String,
    val timestamp: String
)