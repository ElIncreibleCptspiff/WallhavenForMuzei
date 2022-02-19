package com.zorg.wallhavenformuzei.domain

import android.content.Context
import com.zorg.wallhavenformuzei.data.model.Wallpaper as Model
import com.zorg.wallhavenformuzei.data.service.WallhavenService

class GetWallPaper {
    companion object {
        fun get(applicationContext:Context): Model = WallhavenService().getRandomWallpaper(applicationContext)
    }
}