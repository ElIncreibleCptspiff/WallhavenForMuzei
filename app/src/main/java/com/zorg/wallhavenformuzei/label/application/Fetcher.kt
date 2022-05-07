package com.zorg.wallhavenformuzei.label.application

import com.zorg.wallhavenformuzei.label.domain.Label
import com.zorg.wallhavenformuzei.label.domain.LabelProvider

class Fetcher {
    fun getRandom(provider: LabelProvider): Label {
        return provider.getRandom()
    }

    fun getAll(provider: LabelProvider): List<Label> {
        return provider.getAll()
    }
}