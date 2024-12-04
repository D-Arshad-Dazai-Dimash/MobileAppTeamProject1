package com.example.project_modile_application.presentation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.project_modile_application.data.internet.KinoPoiskApi
import com.example.project_modile_application.data.internet.apiService
import com.example.project_modile_application.domain.dataclasses.Movie
import com.example.project_modile_application.domain.viewModels.HomeViewModel
import com.example.project_modile_application.domain.viewModels.RoomViewModel
import com.example.project_modile_application.domain.viewModels.SharedViewModel
import com.example.project_modile_application.presentation.ui.screen.filmography.FilmographyScreen
import com.example.project_modile_application.presentation.ui.screen.filmpage.FilmPageScreen
import com.example.project_modile_application.presentation.ui.screen.listingPage.IntoCategory_Screen
import com.example.project_modile_application.presentation.ui.screen.searchpage.SearchPage


@Composable
fun Home(navController: NavController , sharedViewModel: SharedViewModel) {
    val homeViewModel = HomeViewModel(apiService)
    com.example.project_modile_application.presentation.ui.screen.home.Home(
        navController,
        homeViewModel,
        sharedViewModel
    )
}


@Composable
fun Search(navController: NavController) {
    SearchPage(navController)
}

@Composable
fun Profile(navController: NavController , roomViewModel: RoomViewModel) {
    com.example.project_modile_application.presentation.ui.screen.profilePage.ProfileScreen(navController , roomViewModel)
}

@Composable
fun OnBoarding(navController: NavController) {
    com.example.project_modile_application.presentation.ui.screen.onboarding.OnBoardingScreen(
        navController
    )
}

@Composable
fun ListingPage(
    navController: NavController,
    apiService: KinoPoiskApi,
    category: String,
    sharedViewModel: SharedViewModel
) {
    IntoCategory_Screen(
        navController = navController,
        apiService = apiService,
        category,
        sharedViewModel = sharedViewModel
    )
}

@Composable
fun FilmPage(navController: NavController, movie: Movie , roomViewModel: RoomViewModel) {
    FilmPageScreen(navController, movie , roomViewModel)
}

@Composable
fun GalleryPage(navController: NavController, movieId: Int) {
    com.example.project_modile_application.presentation.ui.screen.galleryPage.GalleryPage(navController, movieId)
}
@Composable
fun FilmographyPage(navController: NavController, sharedViewModel: SharedViewModel) {
    FilmographyScreen(navController,sharedViewModel)
}