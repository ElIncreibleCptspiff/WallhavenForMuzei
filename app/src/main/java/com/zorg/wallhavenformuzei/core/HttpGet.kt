package com.zorg.wallhavenformuzei.core

import com.android.volley.toolbox.RequestFuture
import org.json.JSONObject

interface HttpGet {
    fun getJsonFromUrl(url:String): RequestFuture<JSONObject>
}