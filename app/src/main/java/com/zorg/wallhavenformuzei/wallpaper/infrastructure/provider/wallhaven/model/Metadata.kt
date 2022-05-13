package com.zorg.wallhavenformuzei.wallpaper.infrastructure.provider.wallhaven.model

import com.google.gson.annotations.SerializedName

data class Metadata (
    @SerializedName("current_page") val currentPage: Int,
    @SerializedName("last_page") val lastPage: Int,
    @SerializedName("per_page") val totalPerPage: Int,
    @SerializedName("total") val total: Int,
    @SerializedName("query") val label: String,
)