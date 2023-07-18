package teka.android.retrfitapitemplate

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import teka.android.retrfitapitemplate.data.remote.retrofit.MovieResult
import teka.android.retrfitapitemplate.data.remote.retrofit.RetrofitProvider

class MainViewModel: ViewModel() {
    private val _movieList = MutableStateFlow<List<MovieResult>>(listOf())
    val movieList: StateFlow<List<MovieResult>> = _movieList

    init {
        viewModelScope.launch {
            fetchMovies()
        }
    }

    private suspend fun fetchMovies() {
        val discoverMovies = RetrofitProvider.createMovieService().discoverMovies()
        _movieList.emit(discoverMovies.results)
    }
}