package com.example.project_modile_application

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project_modile_application.data.PosterData
import com.example.project_modile_application.data.internet.KinoPoiskApi
import com.example.project_modile_application.model.Genre
import kotlinx.coroutines.launch

class MoviesViewModel(private val apiService: KinoPoiskApi) : ViewModel() {
    val premiers = mutableStateOf<List<PosterData>>(emptyList())
    val popular = mutableStateOf<List<PosterData>>(emptyList())
    val catastrophe = mutableStateOf<List<PosterData>>(emptyList())

    init {
        loadMovies("premiers")
        loadMovies("popular")
        loadMovies("catastrophe")
    }

    private fun loadMovies(category: String) {
        viewModelScope.launch {
            val response = when (category) {
                "premiers" -> apiService.getMovies(yearFrom = 2023)
                "popular" -> apiService.getMovies(order = "NUM_VOTE")
                "catastrophe" -> apiService.getMovies(genres = Genre("CATASTROPHE_THEME"),
                    order = "RATING", ratingFrom = 8)
                else -> null
            }
            val moviesList = response?.body()?.items?.map {
                PosterData(
                    title = it.nameRu ?: "Unknown",
                    image = it.posterUrl ?: "",
                    genres = it.genres?.map { genre -> genre.genre } ?: emptyList(),
                    countries = it.countries?.map { country -> country.country } ?: emptyList()
                )
            } ?: emptyList()

            when (category) {
                "premiers" -> premiers.value = moviesList
                "popular" -> popular.value = moviesList
                "catastrophe" -> catastrophe.value = moviesList
            }
        }
    }
}