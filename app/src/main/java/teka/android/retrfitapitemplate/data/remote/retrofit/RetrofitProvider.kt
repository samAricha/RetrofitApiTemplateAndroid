package teka.android.retrfitapitemplate.data.remote.retrofit

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object RetrofitProvider {
    private const val BASE_URL = "https://api.themoviedb.org"

    private fun provide(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(provideOkhttpClient())
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    private fun provideOkhttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().also {
                it.level = HttpLoggingInterceptor.Level.BODY
            })
            .addInterceptor(HeaderInterceptor)
            .build()


    fun createMovieService(): MovieService {
        return provide().create(MovieService::class.java)
    }

}