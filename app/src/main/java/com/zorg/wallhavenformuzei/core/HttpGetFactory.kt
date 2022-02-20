package com.zorg.wallhavenformuzei.core

import android.content.Context
import com.zorg.wallhavenformuzei.core.vendor.VolleyHelper
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HttpGetFactory@Inject constructor(
    @ActivityContext private val applicationContext: Context
){
    fun get():HttpGet = VolleyHelper(applicationContext)
}