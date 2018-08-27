package xiaobo0113.xiaobo.com.app_settings

import android.content.Context
import android.content.Intent
import android.os.Bundle

class AppSettingsPipeLineImp : AppSettingsPipeLine {

    override fun startAppSettingsMainActivity(context: Context, bundle: Bundle) {
        val intent = Intent(context, AppSettingsMainActivity::class.java)
        intent.putExtras(bundle)
        startActivity(context, intent)
    }

}
