package com.zorg.wallhavenformuzei.wallpaper.application

import com.zorg.wallhavenformuzei.core.http.HttpGet
import com.zorg.wallhavenformuzei.wallpaper.domain.UriImage
import com.zorg.wallhavenformuzei.wallpaper.domain.Wallpaper
import com.zorg.wallhavenformuzei.wallpaper.domain.WallpaperProvider
import dagger.hilt.android.qualifiers.ActivityContext
import org.json.JSONException
import org.json.JSONObject
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Fetcher @Inject constructor(
    @ActivityContext private val httpGet: HttpGet,
    @ActivityContext private val wallpaperProvider: WallpaperProvider,
){
    fun fetch(label: String): Wallpaper {
        try {
            return wallpaperProvider.getWallPaper(this.getJson(label))
        } catch (e: JSONException) {
            throw JsonSchemaException("error in schema")
        }
    }

    fun getUriImages(): List<UriImage> {
        try {
            return wallpaperProvider.getUriImages()
        } catch (e: JSONException) {
            throw JsonSchemaException("error in schema")
        }
    }

    private fun getJson(label: String): JSONObject {
        return httpGet.getJsonFromUrl(wallpaperProvider.getSearchUrl(label))
    }
}