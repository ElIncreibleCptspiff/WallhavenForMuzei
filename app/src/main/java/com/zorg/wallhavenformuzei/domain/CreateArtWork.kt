package com.zorg.wallhavenformuzei.domain

import android.net.Uri
import com.google.android.apps.muzei.api.provider.Artwork
import com.zorg.wallhavenformuzei.data.model.Wallpaper

class CreateArtWork {
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