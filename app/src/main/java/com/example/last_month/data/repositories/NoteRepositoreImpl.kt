package com.example.last_month.data.repositories

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
) : NoteRepository {
    override fun createNote(noteEntity: Note): kotlinx.coroutines.flow.Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = noteDao.createNote(noteEntity.toEntity())
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?: "unknown error"))
            }
        }.flowOn(Dispatchers.IO)
    }


    override fun getAllNotes(): kotlinx.coroutines.flow.Flow<Resource<List<Note>>>{
        return flow {
            emit(Resource.Loading())
            try {
                val data = noteDao.getAllNotes().map { it.toNote() }
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?: "unknown error"))
            }
        }
    }


    override fun editNote(noteEntity: Note) : kotlinx.coroutines.flow.Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = noteDao.editNote(noteEntity.toEntity())
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?: "unknown error"))
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun removeNote(noteEntity: Note) : kotlinx.coroutines.flow.Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = noteDao.removeNote(noteEntity.toEntity())
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?: "unknown error"))
            }
        }.flowOn(Dispatchers.IO)
    }

}