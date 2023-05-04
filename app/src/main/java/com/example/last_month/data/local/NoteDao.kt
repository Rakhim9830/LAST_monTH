package com.example.last_month.data.local

import androidx.room.*
import com.example.last_month.data.model.NoteEntity

@Dao
interface NoteDao {
    @Insert
    suspend fun createNote(noteEntity: NoteEntity)
    @Query("SELECT * FROM notes")
    suspend fun getAllNotes():List<NoteEntity>
    @Update
    suspend fun editNote(noteEntity: NoteEntity)
    @Delete
    suspend fun removeNote(noteEntity: NoteEntity)
}