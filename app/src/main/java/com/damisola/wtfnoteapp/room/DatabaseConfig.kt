package com.damisola.wtfnoteapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.damisola.wtfnoteapp.models.Note

object DatabaseConfig {
    fun getInstance(context:Context): AppDatabase{
        var db = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "note_db"
        ).build()
        return db

    }
}

@Database(entities = [Note::class], version = 2)
abstract class AppDatabase: RoomDatabase(){
    abstract  fun noteDao(): NoteDao
}