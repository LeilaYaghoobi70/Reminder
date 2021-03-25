package ly.project.reminder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ly.project.reminder.utils.initUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUtils(applicationContext)
    }
}