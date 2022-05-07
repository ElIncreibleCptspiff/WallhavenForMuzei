package com.zorg.wallhavenformuzei.label.domain

interface LabelProvider {
    fun getRandom(): Label

    fun getAll(): List<Label>
}