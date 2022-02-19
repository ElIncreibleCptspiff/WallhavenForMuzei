package com.zorg.wallhavenformuzei

import com.google.android.apps.muzei.api.provider.MuzeiArtProvider

class WallhavenArtProvider  : MuzeiArtProvider() {
    override fun onLoadRequested(initial: Boolean) {
        val context = context ?: return
        WallhavenWorker.enqueueLoad(context)
    }
}