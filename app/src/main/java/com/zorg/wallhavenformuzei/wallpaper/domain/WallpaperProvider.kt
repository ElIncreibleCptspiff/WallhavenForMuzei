package com.zorg.wallhavenformuzei.wallpaper.domain
import org.json.JSONObject

interface WallpaperProvider {
    fun getSearchUrl(label: String): String
    fun getWallPaper(result: JSONObject): Wallpaper
    fun getUriImages(): List<UriImage>
}