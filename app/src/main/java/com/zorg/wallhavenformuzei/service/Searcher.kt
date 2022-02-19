package com.zorg.wallhavenformuzei.service

import android.content.Context
import android.content.res.Resources
import android.net.Uri
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.RequestFuture
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class Searcher {
    companion object {
        const val TAG = "ZORG::"

        const val SEARCH_URL = "https://wallhaven.cc/api/v1/search"
        const val RATIO = "16x9,9x16,portrait"

        fun search(applicationContext: Context): RequestFuture<JSONObject> {
            val future = RequestFuture.newFuture<JSONObject>()
            val request = JsonObjectRequest(Request.Method.GET, getSearchUrl(), null, future, future)
            Volley.newRequestQueue(applicationContext).add(request)
            Log.e(TAG, getSearchUrl())
            return future
        }

        private fun getSearchUrl(): String {
            return Uri.parse(SEARCH_URL)
                .buildUpon()
                .appendQueryParameter("q", "pixel")
                .appendQueryParameter("atleast", getResolution())
                .appendQueryParameter("ratio", RATIO)
                .build().toString()
        }

        private fun getResolution(): String {
            val displayMetrics = Resources.getSystem().getDisplayMetrics();
            return displayMetrics.widthPixels.toString() + "x" + displayMetrics.heightPixels.toString()
        }
    }
}