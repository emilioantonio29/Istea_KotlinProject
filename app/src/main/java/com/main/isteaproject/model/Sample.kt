package com.main.isteaproject.model

import kotlinx.serialization.Serializable

@Serializable
data class Sample(
    val data: List<Data>
)

@Serializable
data class Data(
    val precio: Int,
    val tipo: String,
    val moneda: String,
    val imagen: String,
    val nombre: String,
    val id: String,
    val cantidad: Int,
    val descript: String
)