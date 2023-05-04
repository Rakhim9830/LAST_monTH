package com.example.last_month.data.repositories

import com.example.last_month.data.local.NoteDao
import com.example.last_month.data.model.NoteEntity
import com.example.last_month.domain.model.Note
import com.example.last_month.domain.repositories.NoteRepository

class NoteRepositoreImpl(
    private val noteDao: NoteDao,

):NoteRepository {
    override fun createNote(noteEntity: Note) {
       noteDao.createNote(noteEntity)
    }

    override fun getAllNotes(): List<Note> {

    }

    override fun editNote(noteEntity: Note) {

    }

    override fun removeNote(noteEntity: Note) {

    }
}