package com.zorg.wallhavenformuzei.wallpaper

import android.content.Context
import android.net.Uri
import com.google.android.apps.muzei.api.provider.Artwork
import com.zorg.wallhavenformuzei.core.http.HttpGetFactory
import com.zorg.wallhavenformuzei.wallpaper.domain.Wallpaper
import com.zorg.wallhavenformuzei.wallpaper.application.WallpaperFetcher
import com.zorg.wallhavenformuzei.label.Service as LabelService

class Service () {
    fun get(applicationContext: Context): Wallpaper {
        val httpGet = HttpGetFactory(applicationContext).get()
        val labelFetcher = LabelService()
        val fetcher = WallpaperFetcher()
        return fetcher.fetch(httpGet, labelFetcher.get().title)
    }
}