package ly.project.reminder

import android.app.Application
import ly.project.reminder.di.module.AppComponent
import ly.project.reminder.di.module.DaggerAppComponent


class App : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}