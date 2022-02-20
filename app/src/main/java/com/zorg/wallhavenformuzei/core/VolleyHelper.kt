package com.zorg.wallhavenformuzei.core

import android.content.Context
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.RequestFuture
import com.android.volley.toolbox.Volley
import dagger.hilt.android.qualifiers.ActivityContext
import org.json.JSONObject
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VolleyHelper @Inject constructor(
        @ActivityContext private val applicationContext: Context
) {
    fun getJsonFromUrl(url:String): RequestFuture<JSONObject> {
        val future = RequestFuture.newFuture<JSONObject>()
        val request = JsonObjectRequest(Request.Method.GET, url, null, future, future)
        Volley.newRequestQueue(applicationContext).add(request)
        return future
    }
}