package `in`.onlycashbacks.twa

import timber.log.Timber

class DelegationService : com.google.androidbrowserhelper.trusted.DelegationService() {
    override fun onCreate() {
        super.onCreate()
        Timber.d("DelegationService created")
    }
}
