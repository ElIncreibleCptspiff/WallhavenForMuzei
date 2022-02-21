package com.zorg.wallhavenformuzei.core

import org.json.JSONObject

interface HttpGet {
    fun getJsonFromUrl(url:String): JSONObject
}