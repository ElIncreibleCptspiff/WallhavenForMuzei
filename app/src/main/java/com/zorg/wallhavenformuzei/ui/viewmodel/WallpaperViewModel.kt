package com.zorg.wallhavenformuzei.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.zorg.wallhavenformuzei.core.HttpGetFactory
import com.zorg.wallhavenformuzei.domain.GetWallpaper
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class WallpaperViewModel@Inject constructor(
    @ActivityContext private val applicationContext: Context
) : ViewModel() {
    var httpGet = HttpGetFactory(applicationContext).get()
    var getWallpaper = GetWallpaper(httpGet)
}