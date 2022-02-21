package com.zorg.wallhavenformuzei.data.service

import com.zorg.wallhavenformuzei.data.model.Wallpaper

interface WallpaperApiClient {
    fun getRandomWallpaper(): Wallpaper
}