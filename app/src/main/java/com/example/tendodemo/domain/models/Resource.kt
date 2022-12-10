package com.example.tendodemo.domain.models

data class Resource(
    val active: Boolean,
    val actor: Actor,
    val address: List<Addres>,
    val appointment: Appointment,
    val birthDate: String,
    val code: Code,
    val contact: List<Contact>,
    val gender: String,
    val id: String,
    val meta: Meta,
    val name: List<Name>,
    val period: Period,
    val resourceType: String,
    val status: String,
    val subject: Subject,
    val type: List<Type>
)