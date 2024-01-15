package com.damisola.wtfnoteapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.damisola.wtfnoteapp.models.Note

@Dao
interface NoteDao {
    @Insert
    suspend fun savedNote(note: Note)

    @Query("select * from notes")
    fun fetchNotes(): LiveData<List<Note>>

    @Query("SELECT * FROM notes WHERE id = :noteId")
    fun fetchNote(noteId: String): LiveData<Note>

    @Delete
    suspend fun deleteNote(note: Note)
}