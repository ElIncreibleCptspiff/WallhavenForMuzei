package com.zorg.wallhavenformuzei.data.service.wallhaven

import android.content.res.Resources
import android.net.Uri
import com.zorg.wallhavenformuzei.core.HttpGet
import com.zorg.wallhavenformuzei.data.model.Wallpaper
import com.zorg.wallhavenformuzei.data.error.NoItemsException
import com.zorg.wallhavenformuzei.data.service.WallpaperApiClient
import org.json.JSONArray
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WallhavenService @Inject constructor(private val httpGet: HttpGet): WallpaperApiClient {

    companion object {
        const val SEARCH_URL = "https://wallhaven.cc/api/v1/search"
        const val RATIO = "16x9,9x16,portrait"
    }

    override fun getRandomWallpaper(): Wallpaper {
        val searchJson = httpGet.getJsonFromUrl(getSearchUrl())
        return deserialize(searchJson.getJSONArray("data"))
    }

    private fun getSearchUrl(): String {
        return Uri.parse(SEARCH_URL)
            .buildUpon()
            .appendQueryParameter("q", "pixel art")
            .appendQueryParameter("atleast", getResolution())
            .appendQueryParameter("ratio", RATIO)
            .build().toString()
    }

    private fun getResolution(): String {
        val displayMetrics = Resources.getSystem().getDisplayMetrics()
        return displayMetrics.widthPixels.toString() + "x" + displayMetrics.heightPixels.toString()
    }

    private fun deserialize(wallpapers: JSONArray): Wallpaper {
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
}