package com.zorg.wallhavenformuzei.data.service

import android.content.Context
import com.zorg.wallhavenformuzei.data.service.wallhaven.WallhavenService
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WallpaperApiClientFactory @Inject constructor(
    @ActivityContext private val applicationContext: Context
){
    fun getClient(): WallpaperApiClient = WallhavenService(applicationContext)
}