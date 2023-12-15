package com.damisola.wtfnoteapp.room

import androidx.room.Dao
import androidx.room.Insert
import com.damisola.wtfnoteapp.models.Note

@Dao
interface NoteDao {
    @Insert
    suspend fun savedNote(note: Note)
}