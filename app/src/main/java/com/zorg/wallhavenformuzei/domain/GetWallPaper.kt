package com.zorg.wallhavenformuzei.domain

import android.content.Context
import com.zorg.wallhavenformuzei.data.model.Wallpaper as Model
import com.zorg.wallhavenformuzei.data.service.WallpaperApiClientFactory
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class GetWallPaper@Inject constructor(
    @ActivityContext private val applicationContext: Context
) {
    fun get(): Model = WallpaperApiClientFactory(applicationContext)
        .getClient()
        .getRandomWallpaper()
}