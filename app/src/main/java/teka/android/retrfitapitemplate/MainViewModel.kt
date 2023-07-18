package teka.android.retrfitapitemplate

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import teka.android.retrfitapitemplate.data.remote.retrofit.MovieResult
import teka.android.retrfitapitemplate.data.remote.retrofit.RetrofitProvider

class MainViewModel: ViewModel() {
    val movieList = mutableStateOf(listOf<MovieResult>())

    init {
        viewModelScope.launch {
            val discoverMovies = RetrofitProvider.createMovieService().discoverMovies()
            movieList.value = discoverMovies.results
        }
    }
}