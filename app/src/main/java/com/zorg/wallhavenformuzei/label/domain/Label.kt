package com.zorg.wallhavenformuzei.label.domain

import com.google.gson.annotations.SerializedName

data class Label (
    @SerializedName("title") val title: String
)