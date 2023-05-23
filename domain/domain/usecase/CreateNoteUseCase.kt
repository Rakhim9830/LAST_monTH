package com.example.last_month.domain.usecase

import com.example.last_month.domain.model.Note
import com.example.last_month.domain.repositories.NoteRepository
import javax.inject.Inject

class CreateNoteUseCase  @Inject constructor(private val noteRepository: NoteRepository) {
    fun createNote(note: Note) = noteRepository.createNote(note)
}