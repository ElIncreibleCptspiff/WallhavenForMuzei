package com.zorg.wallhavenformuzei.wallpaper.application

import com.zorg.wallhavenformuzei.core.http.HttpGet
import com.zorg.wallhavenformuzei.wallpaper.domain.Wallpaper
import com.zorg.wallhavenformuzei.wallpaper.domain.Wallhaven
import org.json.JSONException

class WallpaperFetcher {

    private val wallhaven = Wallhaven()

    fun fetch(httpGet: HttpGet, label: String): Wallpaper {
        val searchJson = httpGet.getJsonFromUrl(wallhaven.getSearchUrl(label))
        try {
            return wallhaven.deserialize(searchJson)
        } catch (e: JSONException) {
            throw JsonSchemaException("error in schema")
        }
    }
}