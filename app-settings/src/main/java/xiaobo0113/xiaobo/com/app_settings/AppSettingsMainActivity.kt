package xiaobo0113.xiaobo.com.app_settings

import android.os.Bundle
import android.widget.TextView

import xiaobo0113.xiaobo.com.app_base.BaseActivity

class AppSettingsMainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val textView = TextView(this)
        textView.text = "this is AppSettingsMainActivity..."
        setContentView(textView)
    }

}
