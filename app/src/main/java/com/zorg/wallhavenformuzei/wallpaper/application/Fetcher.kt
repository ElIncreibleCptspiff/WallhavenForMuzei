package com.zorg.wallhavenformuzei.wallpaper.application

import com.zorg.wallhavenformuzei.core.http.HttpGet
import com.zorg.wallhavenformuzei.wallpaper.domain.Wallpaper
import com.zorg.wallhavenformuzei.wallpaper.domain.WallpaperProvider
import org.json.JSONException

class Fetcher {

    fun fetch(httpGet: HttpGet, wallpaperProvider: WallpaperProvider, label: String): Wallpaper {
        val searchJson = httpGet.getJsonFromUrl(wallpaperProvider.getSearchUrl(label))
        try {
            return wallpaperProvider.deserialize(searchJson)
        } catch (e: JSONException) {
            throw JsonSchemaException("error in schema")
        }
    }
}