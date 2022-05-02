package com.zorg.wallhavenformuzei.wallpaper.infrastructure.provider

import android.content.res.Resources
import android.net.Uri
import com.zorg.wallhavenformuzei.wallpaper.domain.Wallpaper
import com.zorg.wallhavenformuzei.wallpaper.domain.WallpaperProvider
import org.json.JSONArray
import org.json.JSONObject

class Wallhaven: WallpaperProvider {

    companion object {
        const val SEARCH_URL = "https://wallhaven.cc/api/v1/search"
        const val RATIO = "16x9,9x16,portrait"
        const val JSON_KEY = "data"
    }

    override fun getSearchUrl(label: String): String {
        return Uri.parse(SEARCH_URL)
            .buildUpon()
            .appendQueryParameter("q", label)
            .appendQueryParameter("atleast", getResolution())
            .appendQueryParameter("ratio", RATIO)
            .build().toString()
    }

    override fun deserialize(result: JSONObject): Wallpaper {
        return deserializeJsonArray(result.getJSONArray(JSON_KEY))
    }

    private fun deserializeJsonArray(wallpapers: JSONArray): Wallpaper {
        if (wallpapers.length() == 0) {
            throw NoItemsException("Empty search")
        }
        val jsonWallpaper = wallpapers.getJSONObject((0 until wallpapers.length()).random())
        return Wallpaper(
            jsonWallpaper.getString("id"),
            jsonWallpaper.getString("created_at"),
            jsonWallpaper.getString("category"),
            jsonWallpaper.getString("id"),
            jsonWallpaper.getString("id"),
            jsonWallpaper.getString("id"),
            jsonWallpaper.getString("path"),
            jsonWallpaper.getString("short_url")
        )
    }

    private fun getResolution(): String {
        val displayMetrics = Resources.getSystem().getDisplayMetrics()
        return displayMetrics.widthPixels.toString() + "x" + displayMetrics.heightPixels.toString()
    }
}