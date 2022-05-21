package com.zorg.wallhavenformuzei.label.infrastructure

import android.content.Context
import com.zorg.wallhavenformuzei.R
import com.zorg.wallhavenformuzei.label.application.Fetcher
import com.zorg.wallhavenformuzei.label.domain.Label
import com.zorg.wallhavenformuzei.label.infrastructure.database.LabelDatabase

class Service(val context: Context) {
    fun getRandom(): Label {
        return Fetcher().getRandom(RoomProvider(getRoomDB()))
    }

    fun getAll(): List<Label> {
        return Fetcher().getAll(HardCodedProvider())
    }

    fun getRoomDB(): LabelDatabase {
        return LabelDatabase.getInstance(context)
    }
}