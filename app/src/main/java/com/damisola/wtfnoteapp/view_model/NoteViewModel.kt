package com.damisola.wtfnoteapp.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Database
import androidx.room.Room
import com.damisola.wtfnoteapp.models.Note
import com.damisola.wtfnoteapp.room.AppDatabase
import com.damisola.wtfnoteapp.room.DatabaseConfig
import kotlinx.coroutines.launch

class NoteViewModel(private val applicationn: Application) : AndroidViewModel(applicationn) {
    // Calling the save function of the database
  private  var db = DatabaseConfig.getInstance(applicationn)


    fun saveNote(title: String, content: String){
        if(title.isNullOrEmpty() || content.isNullOrEmpty()) return
        // Creating a Note instance
        val note = Note(
            title = title,
            content = content
        )

        viewModelScope.launch {
            db.noteDao().savedNote(note)
        }


    }

    fun getAllNote(): LiveData<List<Note>>{
        return  db.noteDao().fetchNotes()
    }

    fun getNote(noteId: String): LiveData<Note>{
        return  db.noteDao().fetchNote(noteId)

    }
    fun deleteNote(note: Note){
        viewModelScope.launch {
            db.noteDao().deleteNote( note)

        }
    }
}