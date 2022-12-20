package com.example.tendodemo.domain.models

data class Name(
    val family: String? = null,
    val given: List<String> = emptyList(),
    val text: String? = null
)