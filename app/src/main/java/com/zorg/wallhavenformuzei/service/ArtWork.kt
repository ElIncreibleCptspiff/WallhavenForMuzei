package com.zorg.wallhavenformuzei.service

import android.net.Uri
import com.google.android.apps.muzei.api.provider.Artwork
import com.zorg.wallhavenformuzei.error.NoItemsException
import org.json.JSONObject
import kotlin.random.Random

class ArtWork {
    companion object {

        fun build(response: JSONObject): Artwork {
            val data = response.getJSONArray("data")
            if (data.length() == 0) {
                throw NoItemsException("Empty search")
            }
            val pic  = data.getJSONObject(Random.nextInt(0, data.length()-1))
            return getArtworkFromPicData(pic)
        }

        private fun getArtworkFromPicData(pic: JSONObject): Artwork {
            return Artwork.Builder()
                .attribution(pic.getString("category"))
                .byline(pic.getString("created_at"))
                .metadata(pic.getString("id"))
                .title(pic.getString("id"))
                .token(pic.getString("id"))
                .persistentUri(Uri.parse(pic.getString("path")))
                .webUri(Uri.parse(pic.getString("short_url")))
                .build()
        }
    }
}