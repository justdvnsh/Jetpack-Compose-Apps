package divyansh.tech.netflixclone.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import divyansh.tech.netflixclone.presentation.splash.SplashAppBar
import divyansh.tech.netflixclone.app.theme.NetflixCloneTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity  : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = hiltViewModel<MainViewModel>()
            viewModel.getTrendingMovies()
            NetflixCloneTheme {
                SplashAppBar(backgroundColor = Color.Transparent)
            }
        }
    }
}