package xiaobo0113.xiaobo.com.app_settings

import android.app.Application

import xiaobo0113.xiaobo.com.app_base.pipeline.PipeLineFactory

class AppSettingsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        PipeLineFactory.registerPipeLine("xiaobo0113.xiaobo.com.app_settings.AppSettingsPipeLine", AppSettingsPipeLineImp())
    }

}
