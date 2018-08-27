package xiaobo0113.xiaobo.com.app_home

import android.content.Context
import android.os.Bundle
import xiaobo0113.xiaobo.com.app_base.pipeline.PipeLine

interface AppHomePipeLine : PipeLine {
    fun startAppHomeMainActivity(context: Context, bundle: Bundle)
}
