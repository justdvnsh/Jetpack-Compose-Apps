package divyansh.tech.netflixclone.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NetflixCloneApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}