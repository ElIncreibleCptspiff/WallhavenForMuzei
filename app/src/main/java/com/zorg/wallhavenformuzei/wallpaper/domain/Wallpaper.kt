package com.zorg.wallhavenformuzei.wallpaper.domain

import com.google.gson.annotations.SerializedName

data class Wallpaper (
    @SerializedName("id") val id: String,
    @SerializedName("byLine") val byLine: String,
    @SerializedName("attribution") val attribution: String,
    @SerializedName("metadata") val metadata: String,
    @SerializedName("title") val title: String,
    @SerializedName("token") val token: String,
    @SerializedName("persistentUri") val persistentUri: String,
    @SerializedName("webUri") val webUri: String
)