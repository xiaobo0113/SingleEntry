package xiaobo0113.xiaobo.com.app_home

import android.content.Context
import android.content.Intent
import android.os.Bundle

class AppHomePipeLineImp : AppHomePipeLine {
    override fun startAppHomeMainActivity(context: Context, bundle: Bundle) {
        val intent = Intent(context, AppHomeMainActivity::class.java)
        intent.putExtras(bundle)
        startActivity(context, intent)
    }
}
