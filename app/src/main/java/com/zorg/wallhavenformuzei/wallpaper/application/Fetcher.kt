package com.zorg.wallhavenformuzei.wallpaper.application

import com.zorg.wallhavenformuzei.wallpaper.domain.UriImage
import com.zorg.wallhavenformuzei.wallpaper.domain.Wallpaper
import com.zorg.wallhavenformuzei.wallpaper.domain.WallpaperProvider
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Fetcher @Inject constructor(
    @ActivityContext private val wallpaperProvider: WallpaperProvider,
){
    fun fetch(label: String): Wallpaper {
        return wallpaperProvider.getWallPaper(label)
    }

    suspend fun getUriImages(label: String): List<UriImage> {
        return wallpaperProvider.getUriImages(label)
    }
}