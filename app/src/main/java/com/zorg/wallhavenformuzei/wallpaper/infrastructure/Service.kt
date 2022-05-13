package com.zorg.wallhavenformuzei.wallpaper.infrastructure

import com.zorg.wallhavenformuzei.wallpaper.domain.Wallpaper
import com.zorg.wallhavenformuzei.wallpaper.application.Fetcher
import com.zorg.wallhavenformuzei.wallpaper.infrastructure.provider.wallhaven.Wallhaven

import com.zorg.wallhavenformuzei.label.infrastructure.Service as LabelService

class Service {
    val wallhavenFetcher = Fetcher(Wallhaven())

    fun getFromWallHaven(): Wallpaper {
        val label = LabelService().getRandom()
        return wallhavenFetcher.fetch(label.title)
    }
}