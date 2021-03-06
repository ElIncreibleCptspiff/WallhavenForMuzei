package com.zorg.wallhavenformuzei.label.infrastructure

import com.zorg.wallhavenformuzei.label.domain.Label
import com.zorg.wallhavenformuzei.label.domain.LabelProvider

class HardCodedProvider: LabelProvider {

    override fun getRandom(): Label {
        return this.getAll()[(this.getAll().indices).random()]
    }

    override fun getAll(): List<Label> {
        return labels
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
        Label(title = "Kimi no Na Wa"),
        Label(title = "Miyamizu Mitsuha"),
    )
}