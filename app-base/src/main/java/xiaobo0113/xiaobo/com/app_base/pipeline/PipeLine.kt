package xiaobo0113.xiaobo.com.app_base.pipeline

import android.app.Activity
import android.content.Context
import android.content.Intent

interface PipeLine {
    fun startActivity(context: Context, intent: Intent) {
        if (context !is Activity) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(intent)
    }

    fun startActivityForResult(activity: Activity, intent: Intent, requestCode: Int) {
        activity.startActivityForResult(intent, requestCode)
    }
}
