package com.example.last_month.data.local

import androidx.room.Database
import com.example.last_month.data.model.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
 abstract class NoteDataBase {
  abstract fun noteDao():NoteDao
}