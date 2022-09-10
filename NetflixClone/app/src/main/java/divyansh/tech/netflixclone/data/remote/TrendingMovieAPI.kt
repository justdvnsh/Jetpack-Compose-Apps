package divyansh.tech.netflixclone.data.remote

import divyansh.tech.netflixclone.app.utils.Constants.API_PATH_TRENDING
import okhttp3.ResponseBody
import retrofit2.http.GET

interface TrendingMovieAPI {
    @GET(API_PATH_TRENDING)
    suspend fun getTrendingMovies(): ResponseBody
}