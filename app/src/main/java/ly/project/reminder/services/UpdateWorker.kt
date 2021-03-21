package ly.project.reminder.services

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.coroutineScope
import ly.project.reminder.utils.setChangeDateWorker
import ly.project.reminder.utils.update
import ly.project.reminder.utils.updateStoredPreference

const val TAG = "UpdateWorker"

class UpdateWorker(context: Context, workerParams: WorkerParameters) :
    CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result = coroutineScope {
        try {
            setChangeDateWorker(applicationContext)
            updateStoredPreference(applicationContext)
            update(applicationContext, true)
            Result.success()
        } catch (e: Throwable) {
            Log.e(TAG, "Error running UpdateWorker: ", e)
            Result.failure()
        }
    }
}
