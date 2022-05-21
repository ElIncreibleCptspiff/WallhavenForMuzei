package com.zorg.wallhavenformuzei.label.infrastructure.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface LabelDao {

    @Insert
    fun insert(label: LabelEntity)

    @Update
    fun update(label: LabelEntity)

    @Query("SELECT * from label_table ORDER BY name")
    fun getAll(): List<LabelEntity>?

    @Query("SELECT * from label_table WHERE name = :name")
    fun get(name: String): LabelEntity?

    @Query("DELETE FROM label_table WHERE name = :name")
    fun delete(name: String)
}