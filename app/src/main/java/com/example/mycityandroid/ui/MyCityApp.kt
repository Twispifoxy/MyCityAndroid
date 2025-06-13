package com.example.mycityandroid.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycityandroid.ui.navigation.CityNavGraph
import com.example.mycityandroid.ui.viewmodel.MainViewModel

@Composable
fun MyCityApp() {
    val viewModel: MainViewModel = viewModel()
    CityNavGraph(viewModel)
}