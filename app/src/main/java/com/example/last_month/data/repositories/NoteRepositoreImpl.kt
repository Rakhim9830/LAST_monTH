package com.example.last_month.data.repositories

import com.example.last_month.data.base.BaseRepository
import com.example.last_month.data.local.NoteDao
import com.example.last_month.data.mappers.toEntity
import com.example.last_month.data.mappers.toNote
import com.example.last_month.data.model.NoteEntity
import com.example.last_month.domain.model.Note
import com.example.last_month.domain.repositories.NoteRepository
import com.example.last_month.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.concurrent.Flow

import javax.inject.Inject


class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
) : BaseRepository(), NoteRepository {
    override fun createNote(note: Note) = doRequest{
        noteDao.createNote(note.toEntity())
    }


    override fun getAllNotes()= doRequest{
        noteDao.getAllNotes().map { it.toNote() }
    }


    override fun editNote(note: Note) = doRequest{
        noteDao.editNote(note.toEntity())
    }


    override fun removeNote(note: Note)= doRequest{
        noteDao.removeNote(note.toEntity())
    }


}