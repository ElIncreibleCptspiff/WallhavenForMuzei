package com.zorg.wallhavenformuzei.wallpaper.infrastructure.provider

import android.content.res.Resources
import android.net.Uri
import android.util.Log
import com.zorg.wallhavenformuzei.wallpaper.domain.UriImage
import com.zorg.wallhavenformuzei.wallpaper.domain.Wallpaper
import com.zorg.wallhavenformuzei.wallpaper.domain.WallpaperProvider
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Math.min

class Wallhaven: WallpaperProvider {

    companion object {
        const val SEARCH_URL = "https://wallhaven.cc/api/v1/search"
        const val RATIO = "16x9,9x16,portrait"
        const val JSON_KEY_DATA = "data"
        const val JSON_KEY_META = "meta"
    }

    override fun getSearchUrl(label: String): String {
        return Uri.parse(SEARCH_URL)
            .buildUpon()
            .appendQueryParameter("q", label)
            .appendQueryParameter("atleast", getResolution())
            .appendQueryParameter("ratio", RATIO)
            .build().toString()
    }

    override fun getWallPaper(result: JSONObject): Wallpaper {
        val query = deserializeMetaData(result.get(JSON_KEY_META) as JSONObject)
        return deserializeJsonArray(result.getJSONArray(JSON_KEY_DATA), query)
    }

    override fun getUriImages(): List<UriImage> {
        return listOf(
            UriImage("https://th.wallhaven.cc//small//m9//m9o5xk.jpg"),
            UriImage("https://th.wallhaven.cc//small//e7//e7283l.jpg"),
            UriImage("https://th.wallhaven.cc//small//g7//g7mepe.jpg"),
            UriImage("https://th.wallhaven.cc//small//9m//9m8q31.jpg"),
        )
    }

    private fun deserializeMetaData(metaData: JSONObject): String {
        return metaData.getString("query")
    }

    private fun deserializeJsonArray(jsonArray: JSONArray, query: String): Wallpaper {
        if (jsonArray.length() == 0) {
            throw NoItemsException("Empty search")
        }
        val jsonWallpaper = jsonArray.getJSONObject((0 until jsonArray.length()).random())
        return Wallpaper(
            jsonWallpaper.getString("id"),
            jsonWallpaper.getString("created_at"),
            query,
            jsonWallpaper.getString("id"),
            jsonWallpaper.getString("id"),
            jsonWallpaper.getString("id"),
            jsonWallpaper.getString("path"),
            jsonWallpaper.getString("short_url")
        )
    }

    private fun buildListUriImages(jsonArray: JSONArray, total: Int): List<UriImage> {
        if (jsonArray.length() == 0) {
            throw NoItemsException("Empty search")
        }
        val result = listOf<UriImage>()
        var totalItems = 0
        while (totalItems < total) {
            if (totalItems < jsonArray.length()) {
                val jsonWallpaper = jsonArray.getJSONObject(totalItems)
                result.plus(jsonWallpaper.getString("path"))
            } else {
                result.plus("")
            }
            totalItems++
        }
        return result
    }

    private fun getResolution(): String {
        val displayMetrics = Resources.getSystem().getDisplayMetrics()
        return displayMetrics.widthPixels.toString() + "x" + displayMetrics.heightPixels.toString()
    }
}