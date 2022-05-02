package com.zorg.wallhavenformuzei.core.http

import org.json.JSONObject

interface HttpGet {
    fun getJsonFromUrl(url:String): JSONObject
}