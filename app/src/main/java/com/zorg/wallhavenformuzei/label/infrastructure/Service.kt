package com.zorg.wallhavenformuzei.label.infrastructure

import com.zorg.wallhavenformuzei.label.application.Fetcher
import com.zorg.wallhavenformuzei.label.domain.Label

class Service {
    fun getRandom(): Label {
        return Fetcher().getRandom(HardCodedProvider())
    }

    fun getAll(): List<Label> {
        return Fetcher().getAll(HardCodedProvider())
    }
}