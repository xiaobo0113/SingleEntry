package xiaobo0113.xiaobo.com.app_play

import android.content.Context
import android.content.Intent
import android.os.Bundle
import xiaobo0113.xiaobo.com.app_base.pipeline.PipeLine

interface AppPlayPipeLine : PipeLine {
    fun startAppPlayMainActivity(context: Context, bundle: Bundle)

    companion object {
        const val EXTRA_APP_PLAY_MAIN_FILE_PATH = "extra_app_play_main_file_path"
        const val EXTRA_APP_PLAY_MAIN_FILE_NAME = "extra_app_play_main_file_name"
    }

}
