package teka.android.retrfitapitemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import teka.android.retrfitapitemplate.data.remote.retrofit.MovieResult
import teka.android.retrfitapitemplate.ui.theme.RetrfitApiTemplateTheme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberImagePainter


class MainActivity : ComponentActivity() {
    private val ourViewModel: MainViewModel by viewModels() // Lazily initializing the ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RetrfitApiTemplateTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(25.dp),
                    color = MaterialTheme.colors.background
                ) {
                    val movieList by ourViewModel.movieList.collectAsState()
                    MovieList(movies = movieList)
                }
            }
        }
    }
}

@Composable
fun MovieList(movies: List<MovieResult>) {
//    val imageLoader = rememberImagePainter() // Remember an ImagePainter
    LazyColumn {
        items(movies) { movie ->
            Card(
                modifier = Modifier.padding(8.dp),
                elevation = 8.dp
            ) {
                Column {
                    Image(
                        painter = rememberImagePainter("https://image.tmdb.org/t/p/w500${movie.poster_path}"),
                        contentDescription = "Movie poster",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(200.dp)
                            .fillMaxWidth()
                    )
                    Text(
                        text = "Title: ${movie.title}",
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(
                        text = "Release Date: ${movie.release_date}",
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(
                        text = "Overview: ${movie.overview}",
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(
                        text = "Popularity: ${movie.popularity}",
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(
                        text = "Vote Average: ${movie.vote_average}",
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}
