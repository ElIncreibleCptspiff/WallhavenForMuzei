package com.zorg.wallhavenformuzei.domain

import com.zorg.wallhavenformuzei.core.HttpGet
import com.zorg.wallhavenformuzei.data.model.Wallpaper as Model
import com.zorg.wallhavenformuzei.data.service.WallpaperApiClientFactory
import javax.inject.Inject

class GetWallpaper@Inject constructor(
    private val httpGet: HttpGet
) {
    operator fun invoke(): Model = WallpaperApiClientFactory(httpGet).getClient().getRandomWallpaper()
}