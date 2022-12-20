package com.example.tendodemo.domain.models

data class Resource(
    val active: Boolean? = null,
    val actor: Actor? = null,
    val address: List<Addres> = emptyList(),
    val appointment: Appointment? = null,
    val birthDate: String? = null,
    val code: Code? = null,
    val contact: List<Contact> = emptyList(),
    val gender: String? = null,
    val id: String? = null,
    val meta: Meta? = null,
    val name: List<Name> = emptyList(),
    val period: Period? = null,
    val resourceType: String? = null,
    val status: String? = null,
    val subject: Subject? = null,
    val type: List<Type> = emptyList()
)