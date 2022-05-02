package com.zorg.wallhavenformuzei.label.infrastructure

import com.zorg.wallhavenformuzei.label.application.LabelFetcher
import com.zorg.wallhavenformuzei.label.domain.Label
import com.zorg.wallhavenformuzei.label.domain.LabelProvider

class Service {
    fun get(): Label {
        val provider = HardCodedProvider()
        val labelFetcher = LabelFetcher()
        return labelFetcher.fetch(provider)
    }
}