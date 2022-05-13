package com.zorg.wallhavenformuzei.wallpaper.domain

interface WallpaperProvider {
    fun getWallPaper(label:String): Wallpaper
    suspend fun getUriImages(label:String): List<UriImage>
}