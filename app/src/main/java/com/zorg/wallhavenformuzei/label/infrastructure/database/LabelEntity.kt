package com.zorg.wallhavenformuzei.label.infrastructure.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "label_table")
data class LabelEntity (
    @PrimaryKey()
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "total")
    var total: Int,
)