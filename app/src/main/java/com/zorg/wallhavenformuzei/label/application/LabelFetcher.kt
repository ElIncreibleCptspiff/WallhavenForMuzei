package com.zorg.wallhavenformuzei.label.application

import com.zorg.wallhavenformuzei.label.domain.Label
import com.zorg.wallhavenformuzei.label.domain.LabelProvider

class LabelFetcher {
    fun fetch(provider: LabelProvider): Label {
        return provider.getRandom()
    }
}