package com.zorg.wallhavenformuzei.wallpaper.application

import com.zorg.wallhavenformuzei.core.http.HttpGet
import com.zorg.wallhavenformuzei.wallpaper.domain.Wallpaper
import com.zorg.wallhavenformuzei.wallpaper.domain.WallpaperProvider
import dagger.hilt.android.qualifiers.ActivityContext
import org.json.JSONException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Fetcher @Inject constructor(
    @ActivityContext private val httpGet: HttpGet,
    @ActivityContext private val wallpaperProvider: WallpaperProvider,
){
    fun fetch(label: String): Wallpaper {
        val searchJson = httpGet.getJsonFromUrl(wallpaperProvider.getSearchUrl(label))
        try {
            return wallpaperProvider.deserialize(searchJson)
        } catch (e: JSONException) {
            throw JsonSchemaException("error in schema")
        }
    }
}