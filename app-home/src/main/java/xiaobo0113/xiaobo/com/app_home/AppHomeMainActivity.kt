package xiaobo0113.xiaobo.com.app_home

import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import xiaobo0113.xiaobo.com.app_base.BaseActivity
import xiaobo0113.xiaobo.com.app_base.pipeline.PipeLineFactory
import xiaobo0113.xiaobo.com.app_base.util.LocalTip
import xiaobo0113.xiaobo.com.app_home.work.AppHomeAudioAdapter
import xiaobo0113.xiaobo.com.app_settings.AppSettingsPipeLine
import java.util.concurrent.Executors


class AppHomeMainActivity : BaseActivity() {

    companion object {
        const val TAG = "AppHomeMainActivity"
    }

    private lateinit var mRecyclerView: RecyclerView
    private val mAdapter = AppHomeAudioAdapter()

    private var mQuit = false
    private val mExecutor = Executors.newSingleThreadExecutor()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_home_layout_main_activity)
        mRecyclerView = findViewById(R.id.app_home_recycler_view)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.adapter = mAdapter
        queryAudio()

        findViewById<View>(R.id.app_home_go_to_settings).setOnClickListener {
            val playPipeLine = PipeLineFactory.getPipeLine(AppSettingsPipeLine::class.java)
            LocalTip.tipWhenPipeLineNull(playPipeLine) {
                (playPipeLine as AppSettingsPipeLine).startAppSettingsMainActivity(it.context, Bundle())
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mQuit = true
    }

    private fun queryAudio() {
        mExecutor.execute {
            val cursor = contentResolver.query(
                    MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                    arrayOf(MediaStore.Audio.Media.DATA, MediaStore.Audio.Media.DISPLAY_NAME, MediaStore.Audio.Media.ARTIST),
                    MediaStore.Audio.Media.MIME_TYPE + "=?",
                    arrayOf("audio/mpeg"),
                    null)
            Log.d(TAG, "cursor count: " + cursor.columnCount)

            val list = arrayListOf<AppHomeAudioAdapter.AudioItem>()
            while (cursor.moveToNext()) {
                val filePath = cursor.getString(0)
                val fileName = cursor.getString(1)
                val authorName = cursor.getString(2)
                val item = AppHomeAudioAdapter.AudioItem(filePath, fileName, authorName)
                list.add(item)
                if (mQuit) {
                    break
                }
            }
            cursor.close()

            if (!mQuit) {
                runOnUiThread {
                    mAdapter.setAudioList(list)
                }
            }
        }
    }

}
