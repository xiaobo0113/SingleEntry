package xiaobo0113.xiaobo.com.app_home

import android.app.Application
import xiaobo0113.xiaobo.com.app_base.pipeline.PipeLineFactory

class AppHomeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        PipeLineFactory.registerPipeLine(AppHomePipeLine::class.java.canonicalName, AppHomePipeLineImp())
    }

}
