package com.damisola.wtfnoteapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp
import java.util.Date

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id :Int = 0,
    val title: String,
    val content: String,
    val dateTime : Long,



)
