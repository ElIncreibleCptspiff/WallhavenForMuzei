package com.zorg.wallhavenformuzei.label.application

import com.zorg.wallhavenformuzei.label.domain.Label
import com.zorg.wallhavenformuzei.label.domain.LabelProvider

class LabelFetcher {
    fun fetch(): Label {
        val provider = LabelProvider()
        return provider.getRandom()
    }
}