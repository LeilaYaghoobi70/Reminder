package ly.project.reminder.di.module

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ly.project.reminder.MainActivity

@Component()
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject (mainActivity: MainActivity)
}