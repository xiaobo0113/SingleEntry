package xiaobo0113.xiaobo.com.app_settings

import android.content.Context
import android.os.Bundle
import xiaobo0113.xiaobo.com.app_base.pipeline.PipeLine

interface AppSettingsPipeLine : PipeLine {
    fun startAppSettingsMainActivity(context: Context, bundle: Bundle)
}
