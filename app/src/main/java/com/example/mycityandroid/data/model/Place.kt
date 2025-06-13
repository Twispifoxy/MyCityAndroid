package com.example.mycityandroid.data.model

data class Place(
    val id: Int,
    val name: String,
    val description: String,
    val address: String,
    val workingHours: String? = null,
    val imageResId: Int
)
