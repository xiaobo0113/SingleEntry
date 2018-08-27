package xiaobo0113.xiaobo.com.app_base.util

import android.widget.Toast
import xiaobo0113.xiaobo.com.app_base.BuildConfig
import xiaobo0113.xiaobo.com.app_base.MainApplication
import java.lang.RuntimeException

object LocalTip {

    fun <T> tipWhenPipeLineNull(pipeLine: T?, foo: () -> Unit) {
        if (null == pipeLine) {
            if (BuildConfig.DEBUG) {
                Toast.makeText(MainApplication.getAppContext(), "pipeLine null", Toast.LENGTH_SHORT).show()
            } else {
                throw RuntimeException("pipeLine null, not registered?")
            }
        } else {
            foo()
        }
    }

}