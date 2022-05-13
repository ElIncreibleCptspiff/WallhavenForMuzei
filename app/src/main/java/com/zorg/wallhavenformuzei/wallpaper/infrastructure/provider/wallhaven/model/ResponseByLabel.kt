package com.zorg.wallhavenformuzei.wallpaper.infrastructure.provider.wallhaven.model

import com.google.gson.annotations.SerializedName
import com.zorg.wallhavenformuzei.wallpaper.domain.Wallpaper

data class ResponseByLabel (
    @SerializedName("data") val listData: List<Data>,
    @SerializedName("meta") val meta: Metadata,
)