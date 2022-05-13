package com.zorg.wallhavenformuzei.wallpaper.infrastructure.provider.wallhaven

import android.content.res.Resources
import android.util.Log
import com.zorg.wallhavenformuzei.wallpaper.domain.UriImage
import com.zorg.wallhavenformuzei.wallpaper.domain.Wallpaper
import com.zorg.wallhavenformuzei.wallpaper.domain.WallpaperProvider
import com.zorg.wallhavenformuzei.wallpaper.infrastructure.provider.NoItemsException
import com.zorg.wallhavenformuzei.wallpaper.infrastructure.provider.wallhaven.model.ResponseByLabel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Wallhaven: WallpaperProvider {

    companion object {
        const val SEARCH_URL = "https://wallhaven.cc/api/v1/"
        const val RATIO = "portrait"
    }

    override fun getWallPaper(label:String): Wallpaper {
        val call = getRetroFit().create(ApiService::class.java).getWallpaperByLabel(label, getResolution(), RATIO).execute()
        if (!call.isSuccessful) {
            throw NoItemsException("found 0 items")
        }
        val wallpapers = call.body() as ResponseByLabel
        val randomWallpaperData = wallpapers.listData.random()
        return Wallpaper(
            id = randomWallpaperData.id,
            byLine = randomWallpaperData.created,
            attribution = label,
            metadata = randomWallpaperData.id,
            title = randomWallpaperData.id,
            token = randomWallpaperData.id,
            persistentUri = randomWallpaperData.thumbs.original,
            webUri = randomWallpaperData.shortUrl
        )
    }

    override suspend fun getUriImages(label: String): List<UriImage> {
        val call = getRetroFit().create(ApiService::class.java)
            .getWallpaperByLabel(label, getResolution(), RATIO).execute()
        if (!call.isSuccessful) {
            return emptyList()
        }
        val wallpapers = call.body() as ResponseByLabel
        return wallpapers.listData.map { data -> UriImage(uri = data.thumbs.small) }
    }

    private fun getResolution(): String {
        val displayMetrics = Resources.getSystem().getDisplayMetrics()
        return displayMetrics.widthPixels.toString() + "x" + displayMetrics.heightPixels.toString()
    }

    private fun getRetroFit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(SEARCH_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}