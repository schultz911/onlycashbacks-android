package `in`.onlycashbacks.twa

import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Build
import android.os.Bundle
import `in`.onlycashbacks.twa.util.SecurityUtils
import timber.log.Timber

class LauncherActivity : com.google.androidbrowserhelper.trusted.LauncherActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Prevent screenshots and screen recording for security (Fintech standard)
        window.setFlags(
            android.view.WindowManager.LayoutParams.FLAG_SECURE,
            android.view.WindowManager.LayoutParams.FLAG_SECURE
        )

        // Security checks for Fintech standards
        if (SecurityUtils.isDeviceRooted()) {
            Timber.w("Device is rooted. Proceed with caution or block.")
            // In a real fintech app, we might want to show a warning or close the app
        }
        
        if (SecurityUtils.isRunningOnEmulator()) {
            Timber.i("Running on emulator.")
        }

        // Setting an orientation crashes the app due to the transparent background on Android 8.0
        // Oreo and below. We only set the orientation on Oreo and above. This only affects the
        // splash screen and Chrome will still respect the orientation.
        requestedOrientation = if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
        } else {
            ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
        }
    }

    override fun getLaunchingUrl(): Uri {
        val uri = super.getLaunchingUrl()
        Timber.d("Launching URL: %s", uri)
        return uri
    }
}
