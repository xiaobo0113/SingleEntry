package xiaobo0113.xiaobo.com.app_base.pipeline

import android.text.TextUtils
import java.util.concurrent.ConcurrentHashMap

object PipeLineFactory {

    private val sPipeLines = ConcurrentHashMap<String, PipeLine>()

    fun registerPipeLine(key: String, pipeLine: PipeLine?) {
        if (!TextUtils.isEmpty(key) && null != pipeLine && !sPipeLines.contains(pipeLine)) {
            sPipeLines[key] = pipeLine
        }
    }

    fun unRegisterPipeLine(key: String) {
        if (!TextUtils.isEmpty(key)) {
            sPipeLines.remove(key)
        }
    }

    fun getPipeLine(c: Class<*>): PipeLine? {
        for ((key, value) in sPipeLines) {
            if (TextUtils.equals(key, c.canonicalName)) {
                return value
            }
        }

        return null
    }

}
