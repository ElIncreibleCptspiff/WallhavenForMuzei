package com.zorg.wallhavenformuzei.wallpaper.infrastructure

import android.content.Context
import com.zorg.wallhavenformuzei.core.http.HttpGetFactory
import com.zorg.wallhavenformuzei.wallpaper.domain.Wallpaper
import com.zorg.wallhavenformuzei.wallpaper.application.Fetcher
import com.zorg.wallhavenformuzei.wallpaper.infrastructure.provider.Wallhaven
import com.zorg.wallhavenformuzei.label.infrastructure.Service as LabelService

class Service () {
    fun getFromWallHaven(applicationContext: Context): Wallpaper {
        val httpGet = HttpGetFactory(applicationContext).get()
        val wallpaperProvider = Wallhaven()
        val labelFetcher = LabelService()

        val fetcher = Fetcher()
        return fetcher.fetch(httpGet, wallpaperProvider, labelFetcher.get().title)
    }
}