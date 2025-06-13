package com.example.mycityandroid.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mycityandroid.data.model.Category
import com.example.mycityandroid.ui.components.CategoryItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryListScreen(
    categories: List<Category>,
    onCategoryClick: (Category) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Агрыз",
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(categories) { category ->
                CategoryItem(category, onCategoryClick, Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                )
            }
        }
    }
}
