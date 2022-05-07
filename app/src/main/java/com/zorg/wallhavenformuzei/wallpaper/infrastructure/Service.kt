package com.zorg.wallhavenformuzei.wallpaper.infrastructure

import android.content.Context
import com.zorg.wallhavenformuzei.core.http.HttpGetFactory
import com.zorg.wallhavenformuzei.wallpaper.domain.Wallpaper
import com.zorg.wallhavenformuzei.wallpaper.application.Fetcher
import com.zorg.wallhavenformuzei.wallpaper.infrastructure.provider.Wallhaven
import com.zorg.wallhavenformuzei.label.infrastructure.Service as LabelService

class Service(applicationContext: Context) {
    val wallhavenFetcher = Fetcher(HttpGetFactory(applicationContext).get(), Wallhaven())

    fun getFromWallHaven(): Wallpaper {
        val label = LabelService().getRandom()
        return wallhavenFetcher.fetch(label.title)
    }
}