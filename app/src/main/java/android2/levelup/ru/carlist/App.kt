package android2.levelup.ru.carlist

import android.app.Application
import com.facebook.stetho.Stetho


class App: Application() {

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this);
    }
}