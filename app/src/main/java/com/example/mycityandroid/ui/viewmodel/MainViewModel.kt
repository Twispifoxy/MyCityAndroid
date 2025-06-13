package com.example.mycityandroid.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.mycityandroid.data.model.Category
import com.example.mycityandroid.data.model.Place
import com.example.mycityandroid.data.repository.PlaceRepository

class MainViewModel : ViewModel() {

    private val repository = PlaceRepository

    var selectedCategory by mutableStateOf<Category?>(null)
        private set

    var placesInCategory by mutableStateOf<List<Place>>(emptyList())
        private set

    var selectedPlace by mutableStateOf<Place?>(null)
        private set

    val categories: List<Category> = repository.getAllCategories()

    fun selectCategory(category: Category) {
        selectedCategory = category
        placesInCategory = repository.getPlaces(category)
    }

    fun selectPlace(placeId: Int) {
        selectedPlace = repository
            .getPlaces(selectedCategory ?: return)
            .find { it.id == placeId }
    }
}