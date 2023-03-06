package com.example.lastfall

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application):AndroidViewModel(application) {
    private val repository:Repository
    val readAlldata:LiveData<List<NoteEntity>>

    init {
        val dao:Dao = NoteDatabase.getDatabase(application).Dao()
        repository = Repository(dao)
        readAlldata = repository.readAlldata()
    }

    fun addNote(noteEntity: NoteEntity){
        viewModelScope.launch ( Dispatchers.IO){
            repository.addNote(noteEntity)
        }
    }

    fun deleteNote(noteEntity: NoteEntity){
        viewModelScope.launch ( Dispatchers.IO){
            repository.deleteNote(noteEntity)
        }
    }

    fun updateNote(noteEntity: NoteEntity){
        viewModelScope.launch ( Dispatchers.IO){
            repository.updateNote(noteEntity)
        }
    }

}