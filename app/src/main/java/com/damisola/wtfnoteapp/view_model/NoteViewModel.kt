package com.damisola.wtfnoteapp.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Database
import androidx.room.Room
import com.damisola.wtfnoteapp.models.Note
import com.damisola.wtfnoteapp.room.AppDatabase
import com.damisola.wtfnoteapp.room.DatabaseConfig
import kotlinx.coroutines.launch

class NoteViewModel(val wtfapplication: Application) : AndroidViewModel(wtfapplication) {
    fun saveNote(title: String, content: String){
        // Creating a Note instance
        val note = Note(title = title,
            content = content
        )
        // Calling the save function of the database
      var db = DatabaseConfig.getInstance(wtfapplication)
        viewModelScope.launch {
            db.noteDao().savedNote(note)
        }


    }


}