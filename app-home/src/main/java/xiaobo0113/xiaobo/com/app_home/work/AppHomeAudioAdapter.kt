package xiaobo0113.xiaobo.com.app_home.work

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import xiaobo0113.xiaobo.com.app_base.MainApplication
import xiaobo0113.xiaobo.com.app_base.pipeline.PipeLineFactory
import xiaobo0113.xiaobo.com.app_base.util.LocalTip
import xiaobo0113.xiaobo.com.app_home.R
import xiaobo0113.xiaobo.com.app_play.AppPlayPipeLine

class AppHomeAudioAdapter : RecyclerView.Adapter<AppHomeAudioAdapter.AudioViewHolder>() {

    private val mAudioList = arrayListOf<AudioItem>()

    fun setAudioList(list: List<AudioItem>) {
        mAudioList.clear()
        mAudioList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioViewHolder {
        val context = MainApplication.getAppContext()
        val root = LayoutInflater.from(context).inflate(R.layout.app_home_item_audio, parent, false)
        return AudioViewHolder(root)
    }

    override fun onBindViewHolder(holder: AudioViewHolder, position: Int) {
        val item = mAudioList.get(position)
        holder.mFileNameTextView.text = item.mFileName
        holder.mAuthorNameTextView.text = item.mAuthorName

        holder.itemView.setOnClickListener {
            val playPipeLine = PipeLineFactory.getPipeLine(AppPlayPipeLine::class.java)
            LocalTip.tipWhenPipeLineNull(playPipeLine) {
                val bundle = Bundle()
                bundle.putString(AppPlayPipeLine.EXTRA_APP_PLAY_MAIN_FILE_PATH, item.mFilePath)
                bundle.putString(AppPlayPipeLine.EXTRA_APP_PLAY_MAIN_FILE_NAME, item.mFileName)
                (playPipeLine as AppPlayPipeLine).startAppPlayMainActivity(it.context, bundle)
            }
        }
    }

    override fun getItemCount(): Int {
        return mAudioList.size
    }

    class AudioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mFileNameTextView: TextView = itemView.findViewById(R.id.app_home_audio_item_file_name)
        var mAuthorNameTextView: TextView = itemView.findViewById(R.id.app_home_audio_item_author_name)
    }

    data class AudioItem(val mFilePath: String, val mFileName: String, val mAuthorName: String)

}
