package com.zorg.wallhavenformuzei

import com.google.android.apps.muzei.api.provider.MuzeiArtProvider

class ArtProvider  : MuzeiArtProvider() {
    override fun onLoadRequested(initial: Boolean) {
        val context = context ?: return
        MuzeiWorker.enqueueLoad(context)
    }
}