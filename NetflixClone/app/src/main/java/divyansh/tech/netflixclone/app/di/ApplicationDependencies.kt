package divyansh.tech.netflixclone.app.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import divyansh.tech.netflixclone.app.utils.Constants.BASE_URL
import divyansh.tech.netflixclone.data.remote.TrendingMovieAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationDependencies {

    @Provides
    @Singleton
    internal fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    internal fun provideTrendingApiService(
        retrofit: Retrofit
    ): TrendingMovieAPI = retrofit.create(TrendingMovieAPI::class.java)
}