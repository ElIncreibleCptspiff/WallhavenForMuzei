package com.zorg.wallhavenformuzei.label

import com.zorg.wallhavenformuzei.label.application.LabelFetcher
import com.zorg.wallhavenformuzei.label.domain.Label

class Service {
    fun get(): Label {
        val labelFetcher = LabelFetcher()
        return labelFetcher.fetch()
    }
}