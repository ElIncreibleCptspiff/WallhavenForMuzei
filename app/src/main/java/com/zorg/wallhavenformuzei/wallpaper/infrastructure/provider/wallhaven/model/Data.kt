package com.zorg.wallhavenformuzei.wallpaper.infrastructure.provider.wallhaven.model

import com.google.gson.annotations.SerializedName

data class Data (
    @SerializedName("id") val id: String,
    @SerializedName("thumbs") val thumbs: Thumbs,
    @SerializedName("purity") val purity: String,
    @SerializedName("ratio") val ratio: Float,
    @SerializedName("created_at") val created: String,
    @SerializedName("url") val url: String,
    @SerializedName("short_url") val shortUrl: String,
)