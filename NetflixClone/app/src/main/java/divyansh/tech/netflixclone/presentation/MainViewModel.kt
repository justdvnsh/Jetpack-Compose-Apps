package divyansh.tech.netflixclone.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import divyansh.tech.netflixclone.data.repositories.TrendingMoviesRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val trendingRepo: TrendingMoviesRepository
): ViewModel() {

    fun getTrendingMovies() = viewModelScope.launch {
        trendingRepo.getTrendingMovies()
    }
}