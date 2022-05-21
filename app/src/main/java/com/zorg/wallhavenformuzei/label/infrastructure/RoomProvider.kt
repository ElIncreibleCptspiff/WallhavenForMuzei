package com.zorg.wallhavenformuzei.label.infrastructure

import com.zorg.wallhavenformuzei.label.domain.Label
import com.zorg.wallhavenformuzei.label.domain.LabelProvider
import com.zorg.wallhavenformuzei.label.infrastructure.database.LabelDatabase



class RoomProvider(val labelDatabase: LabelDatabase): LabelProvider {

    override fun getRandom(): Label {
        return getAll()?.random()
    }

    override fun getAll(): List<Label> {
        return labelDatabase.labeldao.getAll()?.map { labelEntity -> Label(labelEntity.name)  } ?: emptyList()
    }
}