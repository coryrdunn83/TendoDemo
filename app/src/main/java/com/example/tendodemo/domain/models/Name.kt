package com.example.tendodemo.domain.models

data class Name(
    val family: String,
    val given: List<String>,
    val text: String
)