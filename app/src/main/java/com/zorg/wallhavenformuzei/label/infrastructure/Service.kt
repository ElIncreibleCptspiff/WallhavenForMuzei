package com.zorg.wallhavenformuzei.label.infrastructure

import com.zorg.wallhavenformuzei.label.application.Fetcher
import com.zorg.wallhavenformuzei.label.domain.Label

class Service {
    fun get(): Label {
        val provider = HardCodedProvider()
        val labelFetcher = Fetcher()
        return labelFetcher.fetch(provider)
    }
}