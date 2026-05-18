package `in`.onlycashbacks.twa.util

import android.os.Build
import java.io.File

object SecurityUtils {

    /**
     * Basic check for root access.
     */
    fun isDeviceRooted(): Boolean {
        val paths = arrayOf(
            "/system/app/Superuser.apk",
            "/sbin/su",
            "/system/bin/su",
            "/system/xbin/su",
            "/data/local/xbin/su",
            "/data/local/bin/su",
            "/system/sd/xbin/su",
            "/system/bin/failsafe/su",
            "/data/local/su"
        )
        for (path in paths) {
            if (File(path).exists()) return true
        }
        return false
    }

    /**
     * Basic check for emulator.
     */
    fun isRunningOnEmulator(): Boolean {
        return (Build.BRAND?.startsWith("generic") == true && Build.DEVICE?.startsWith("generic") == true
                || Build.FINGERPRINT?.startsWith("generic") == true
                || Build.FINGERPRINT?.startsWith("unknown") == true
                || Build.HARDWARE?.contains("goldfish") == true
                || Build.HARDWARE?.contains("ranchu") == true
                || Build.MODEL?.contains("google_sdk") == true
                || Build.MODEL?.contains("Emulator") == true
                || Build.MODEL?.contains("Android SDK built for x86") == true
                || Build.MANUFACTURER?.contains("Genymotion") == true
                || Build.PRODUCT?.contains("sdk_google") == true
                || Build.PRODUCT?.contains("google_sdk") == true
                || Build.PRODUCT?.contains("sdk") == true
                || Build.PRODUCT?.contains("sdk_x86") == true
                || Build.PRODUCT?.contains("vbox86p") == true
                || Build.PRODUCT?.contains("emulator") == true
                || Build.PRODUCT?.contains("simulator") == true)
    }
}
