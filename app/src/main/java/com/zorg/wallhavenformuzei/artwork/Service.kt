package com.zorg.wallhavenformuzei.artwork

import android.net.Uri
import com.google.android.apps.muzei.api.provider.Artwork
import com.zorg.wallhavenformuzei.wallpaper.domain.Wallpaper

class Service {
    companion object {
        fun create(wallpaper: Wallpaper): Artwork = Artwork.Builder()
            .attribution(wallpaper.attribution)
            .byline(wallpaper.byLine)
            .metadata(wallpaper.id)
            .title(wallpaper.title)
            .token(wallpaper.token)
            .persistentUri(Uri.parse(wallpaper.persistentUri))
            .webUri(Uri.parse(wallpaper.webUri))
            .build()
    }
}