package com.zorg.wallhavenformuzei.setting.application

import android.util.Log
import com.zorg.wallhavenformuzei.label.domain.Label
import com.zorg.wallhavenformuzei.setting.domain.LabelCard
import com.zorg.wallhavenformuzei.wallpaper.domain.UriImage
import com.zorg.wallhavenformuzei.wallpaper.application.Fetcher as WallpaperFetcher

class LabelCardCreator {
    suspend fun CreateList(labelList: List<Label>, wallpaperFetcher: WallpaperFetcher): List<LabelCard> {
        return labelList.map { label -> create(label, wallpaperFetcher) }
    }

    suspend private fun create(label:Label, wallpaperFetcher: WallpaperFetcher): LabelCard {
        Log.d("Zorg::", label.title)
        val listUriImages = wallpaperFetcher.getUriImages(label.title)
        Log.d("Zorg::", listUriImages.size.toString())
        return LabelCard(
                label = label.title,
                photo0 = this.addPhoto(0, listUriImages),
                photo1 = this.addPhoto(1, listUriImages),
                photo2 = this.addPhoto(2, listUriImages),
                photo3 = this.addPhoto(3, listUriImages),
           )
    }

    private fun addPhoto(index: Int, list: List<UriImage>): String {
        if (list.size <= index) {
            return ""
        }

       return list[index].uri
    }

}