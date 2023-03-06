package com.example.lastfall

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NoteEntity::class], version = 1, exportSchema = false)
abstract class NoteDatabase:RoomDatabase() {
    abstract fun Dao():Dao

    companion object{
        @Volatile
        private var INSTANCE:NoteDatabase? = null
        fun getDatabase(context: Context):NoteDatabase{
            var tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(context,NoteDatabase::class.java,"notepadd_db").build()
                tempInstance = instance
                return instance
            }
        }
    }
}