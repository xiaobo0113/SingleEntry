package xiaobo0113.xiaobo.com.singleentry

import android.content.Intent
import android.os.Bundle
import xiaobo0113.xiaobo.com.app_base.BaseActivity
import xiaobo0113.xiaobo.com.app_settings.AppSettingsMainActivity

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(Intent(this, AppSettingsMainActivity::class.java))
        finish()
    }

}
