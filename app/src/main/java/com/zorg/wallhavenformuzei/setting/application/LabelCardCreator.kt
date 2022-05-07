package com.zorg.wallhavenformuzei.setting.application

import com.zorg.wallhavenformuzei.label.domain.Label
import com.zorg.wallhavenformuzei.setting.domain.LabelCard
import com.zorg.wallhavenformuzei.wallpaper.application.Fetcher as WallpaperFetcher


class LabelCardCreator {
    fun CreateList(labelList: List<Label>, wallpaperFetcher: WallpaperFetcher): List<LabelCard> {
        return labelList.map { label -> create(label, wallpaperFetcher) }
    }

    private fun create(label:Label, wallpaperFetcher: WallpaperFetcher): LabelCard {
        val listUriImages = wallpaperFetcher.getUriImages()
        return LabelCard(
                label = label.title,
                photo0 = listUriImages[0].uri,
                photo1 = listUriImages[1].uri,
                photo2 = listUriImages[2].uri,
                photo3 = listUriImages[3].uri,
           )
    }

}