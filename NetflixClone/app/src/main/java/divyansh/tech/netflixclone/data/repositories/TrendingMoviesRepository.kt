package divyansh.tech.netflixclone.data.repositories

import android.util.Log
import divyansh.tech.netflixclone.data.remote.TrendingMovieAPI
import retrofit2.Retrofit
import javax.inject.Inject

class TrendingMoviesRepository @Inject constructor(
    private val service: TrendingMovieAPI
) {
    suspend fun getTrendingMovies() {
        val response = service.getTrendingMovies()
        Log.e("TRENDING MOVIESS -> ", response.string())
    }
}