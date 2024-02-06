package com.example.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.model.data.SchoolSat

@Database(entities = [SchoolSat::class], version = 1, exportSchema = false)
abstract class SchoolDB : RoomDatabase() {
    abstract fun getDao(): SchoolDAO

    companion object {
        private var INSTANCE: SchoolDB? = null
        fun getSchoolInstance(context: Context): SchoolDB =
            synchronized(this) {
                var temp = INSTANCE
                return if (temp != null) temp
                else {
                    temp = Room.databaseBuilder(
                        context,
                        SchoolDB::class.java,
                        "school_db"
                    ).build()
                    INSTANCE = temp
                    temp
                }
            }
    }
}