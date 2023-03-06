package com.example.lastfall
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface Dao {
    @Query("SELECT * FROM notepadd ORDER BY id ASC")
    fun readAlldata():LiveData<List<NoteEntity>>

    @Delete
    fun deleteNote(noteEntity: NoteEntity)

    @Insert
    fun addNote(noteEntity: NoteEntity)

    @Update
    fun updateNote(noteEntity: NoteEntity)
}