package com.zorg.wallhavenformuzei.wallpaper.infrastructure.provider.wallhaven

import com.zorg.wallhavenformuzei.wallpaper.infrastructure.provider.wallhaven.model.ResponseByLabel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET ("search?")
    fun getWallpaperByLabel(
        @Query("q") q:String,
        @Query("atleast") atleast:String,
        @Query("ratios") ratios:String
    ): Call<ResponseByLabel>
}