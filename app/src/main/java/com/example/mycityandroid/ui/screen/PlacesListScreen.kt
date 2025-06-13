package com.example.mycityandroid.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mycityandroid.data.model.Place
import androidx.compose.material3.TopAppBar
import com.example.mycityandroid.ui.components.PlaceCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaceListScreen(
    places: List<Place>,
    onPlaceClick: (Place) -> Unit,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Места",
                        style = MaterialTheme.typography.headlineSmall
                    )
                        },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            items(places) { place ->
                PlaceCard(
                    place = place,
                    onClick = { onPlaceClick(place) }
                )
            }
        }
    }
}
