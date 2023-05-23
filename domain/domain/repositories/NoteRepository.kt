package com.example.last_month.domain.repositories

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.last_month.data.model.NoteEntity
import com.example.last_month.domain.model.Note
import com.example.last_month.domain.utils.Resource
import java.util.concurrent.Flow

interface NoteRepository {
 fun createNote(noteEntity: Note): kotlinx.coroutines.flow.Flow<Resource<Unit>>

 fun getAllNotes(): kotlinx.coroutines.flow.Flow<Resource<List<Note>>>

 fun editNote(noteEntity: Note): kotlinx.coroutines.flow.Flow<Resource<Unit>>

 fun removeNote(noteEntity: Note): kotlinx.coroutines.flow.Flow<Resource<Unit>>
}