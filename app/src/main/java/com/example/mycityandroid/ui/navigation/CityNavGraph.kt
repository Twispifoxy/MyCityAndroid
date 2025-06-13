package com.example.mycityandroid.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycityandroid.data.model.Place
import com.example.mycityandroid.ui.screen.CategoryListScreen
import com.example.mycityandroid.ui.screen.PlaceListScreen
import com.example.mycityandroid.ui.screen.PlaceDetailScreen
import com.example.mycityandroid.ui.viewmodel.MainViewModel

@Composable
fun CityNavGraph(
    viewModel: MainViewModel,
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = "categories",
        modifier = modifier
    ) {
        composable("categories") {
            CategoryListScreen(
                categories = viewModel.categories,
                onCategoryClick = {
                    viewModel.selectCategory(it)
                    navController.navigate("places")
                }
            )
        }
        composable("places") {
            PlaceListScreen(
                places = viewModel.placesInCategory,
                onPlaceClick = {
                    viewModel.selectPlace(it.id)
                    navController.navigate("detail")
                },
                onBack = { navController.popBackStack() }
            )
        }
        composable("detail") {
            PlaceDetailScreen(
                place = viewModel.selectedPlace,
                onBack = { navController.popBackStack() }
            )
        }
    }
}