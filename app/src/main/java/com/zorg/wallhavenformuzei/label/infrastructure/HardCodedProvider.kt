package com.zorg.wallhavenformuzei.label.infrastructure

import com.zorg.wallhavenformuzei.label.domain.Label
import com.zorg.wallhavenformuzei.label.domain.LabelProvider

class HardCodedProvider: LabelProvider {

    override fun getRandom(): Label {
        return labels[(labels.indices).random()]
    }

    private val labels = listOf(
        Label(title = "pixel art"),
        Label(title = "retro game"),
        Label(title = "retro style"),
        Label(title = "pixels"),
        Label(title = "arcane"),
        Label(title = "torii"),
        Label(title = "batman"),
        Label(title = "justice league"),
        Label(title = "monkey island"),
        Label(title = "calvin and hobbes"),
        Label(title = "anime"),
    )
}