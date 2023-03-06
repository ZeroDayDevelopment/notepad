package com.example.lastfall

import androidx.lifecycle.LiveData

class Repository(private val dao:Dao) {
    fun readAlldata():LiveData<List<NoteEntity>> = dao.readAlldata()

    suspend fun deleteNote(noteEntity: NoteEntity){
        dao.deleteNote(noteEntity)
    }

    suspend fun addNote(noteEntity: NoteEntity){
        dao.addNote(noteEntity)
    }

    suspend fun updateNote(noteEntity: NoteEntity){
        dao.updateNote(noteEntity)
    }
}