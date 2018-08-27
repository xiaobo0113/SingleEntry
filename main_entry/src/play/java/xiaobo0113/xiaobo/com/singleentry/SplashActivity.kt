package xiaobo0113.xiaobo.com.singleentry

import android.content.Intent
import android.os.Bundle
import xiaobo0113.xiaobo.com.app_base.BaseActivity
import xiaobo0113.xiaobo.com.app_play.AppPlayMainActivity
import xiaobo0113.xiaobo.com.app_play.AppPlayPipeLine

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, AppPlayMainActivity::class.java)
        val path = "/storage/emulated/0/smartisan/music/cloud/1155987_认真的雪.mp3"
        val name = "1155987_认真的雪.mp3"
        intent.putExtra(AppPlayPipeLine.EXTRA_APP_PLAY_MAIN_FILE_PATH, path)
        intent.putExtra(AppPlayPipeLine.EXTRA_APP_PLAY_MAIN_FILE_NAME, name)
        startActivity(intent)
        finish()
    }

}
