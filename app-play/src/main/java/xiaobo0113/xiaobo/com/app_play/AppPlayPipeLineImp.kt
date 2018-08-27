package xiaobo0113.xiaobo.com.app_play

import android.content.Context
import android.content.Intent
import android.os.Bundle

class AppPlayPipeLineImp : AppPlayPipeLine {
    override fun startAppPlayMainActivity(context: Context, bundle: Bundle) {
        val intent = Intent(context, AppPlayMainActivity::class.java)
        intent.putExtras(bundle)
        startActivity(context, intent)
    }
}
