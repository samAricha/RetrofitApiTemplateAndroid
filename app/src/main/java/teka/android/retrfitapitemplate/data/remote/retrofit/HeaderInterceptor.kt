package teka.android.retrfitapitemplate.data.remote.retrofit

import okhttp3.Interceptor

object HeaderInterceptor : Interceptor {

    private const val apiKey = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmMzAxZWQ2MWRiNjk0Njk1NzRhMzA0YWRlOTJhODU1MSIsInN1YiI6IjYwMTJjMGJlMWI3MGFlMDAzZDViYmI4NyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.lvXCwI48a8vHHBBwSt6zTqof1qieOfAJvCW7mCJrmI4"
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        val request = chain.request()
        val newRequest = request.newBuilder()
            .addHeader("Authorization", "Bearer $apiKey")
            .build()
        return chain.proceed(newRequest)
    }
}
