package com.damisola.wtfnoteapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.damisola.wtfnoteapp.models.Note

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun savedNote(note: Note)

    @Query("SELECT * FROM notes order by id DESC")
    fun fetchNotes(): LiveData<List<Note>>

    @Query("SELECT * FROM notes WHERE id = :noteId")
    fun fetchNote(noteId: String): LiveData<Note>

    @Delete
    suspend fun deleteNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)
}