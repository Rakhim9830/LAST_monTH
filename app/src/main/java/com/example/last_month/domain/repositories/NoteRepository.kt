package com.example.last_month.domain.repositories

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.last_month.data.model.NoteEntity
import com.example.last_month.domain.model.Note

interface NoteRepository {
 fun createNote(noteEntity: Note)

 fun getAllNotes():List<Note>

 fun editNote(noteEntity: Note)

 fun removeNote(noteEntity: Note)
}