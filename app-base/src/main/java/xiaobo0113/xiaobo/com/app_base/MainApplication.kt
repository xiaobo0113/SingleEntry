package xiaobo0113.xiaobo.com.app_base

import android.app.Application
import android.content.Context
import xiaobo0113.xiaobo.com.app_base.util.ApplicationDispatcher

class MainApplication : Application() {

    companion object {
        private lateinit var sAppContext: Context
        fun getAppContext(): Context = sAppContext
    }

    override fun onCreate() {
        super.onCreate()
        sAppContext = this
        ApplicationDispatcher.dispatchOnCreate()
    }

}
