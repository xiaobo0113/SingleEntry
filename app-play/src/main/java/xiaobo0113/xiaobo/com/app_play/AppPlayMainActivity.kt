package xiaobo0113.xiaobo.com.app_play

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.TextView
import xiaobo0113.xiaobo.com.app_base.BaseActivity

class AppPlayMainActivity : BaseActivity() {

    private val mPlayer = MediaPlayer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val filePath = intent.getStringExtra(AppPlayPipeLine.EXTRA_APP_PLAY_MAIN_FILE_PATH)
        val fileName = intent.getStringExtra(AppPlayPipeLine.EXTRA_APP_PLAY_MAIN_FILE_NAME)

        val textView = TextView(this)
        textView.text = "now is playing: $fileName"
        setContentView(textView)

        mPlayer.setDataSource(filePath)
        mPlayer.prepare()
        mPlayer.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPlayer.stop()
        mPlayer.release()
    }

}
