package com.zorg.wallhavenformuzei.data.service

import com.zorg.wallhavenformuzei.core.HttpGet
import com.zorg.wallhavenformuzei.data.service.wallhaven.WallhavenService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WallpaperApiClientFactory @Inject constructor(
    private val httpGet: HttpGet
){
    fun getClient(): WallpaperApiClient = WallhavenService(httpGet)
}