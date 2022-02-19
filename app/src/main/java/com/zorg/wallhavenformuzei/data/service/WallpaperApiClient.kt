package com.zorg.wallhavenformuzei.data.service

import android.content.Context
import com.zorg.wallhavenformuzei.data.model.Wallpaper


interface WallpaperApiClient {
    fun getRandomWallpaper(applicationContext: Context): Wallpaper
}