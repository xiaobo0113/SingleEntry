package xiaobo0113.xiaobo.com.app_base.util

import android.app.Application
import android.text.TextUtils
import xiaobo0113.xiaobo.com.app_base.MainApplication
import java.util.*

/**
 * Created by moxiaobo on 17/6/26.
 */

object ApplicationDispatcher {

    private val TAG = ApplicationDispatcher::class.java.simpleName
    private val sSubApplications = ArrayList<Application>()
    private val SUB_APPLICATIONS = "SUB_APPLICATIONS"

    init {
        val context = MainApplication.getAppContext()
        val bundle = context.applicationInfo.metaData
        val subApplications = bundle.getString(SUB_APPLICATIONS)!!.trim()

        val applications = subApplications.split(";")
        for (application in applications) {
            if (TextUtils.isEmpty(application)) {
                continue
            }

            try {
                val clazz = Class.forName(application.trim())
                sSubApplications.add(clazz.newInstance() as Application)
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            } catch (e: InstantiationException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            }

        }
    }

    fun dispatchOnCreate() {
        for (application in sSubApplications) {
            application.onCreate()
        }
    }

}
