package com.zorg.wallhavenformuzei.label.infrastructure.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [LabelEntity::class], version = 1, exportSchema = false)
abstract class LabelDatabase : RoomDatabase() {

    abstract val labeldao: LabelDao

    companion object {
        @Volatile
        private var INSTANCE: LabelDatabase? = null

        fun getInstance(context: Context): LabelDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext, LabelDatabase::class.java,"label_database")
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}