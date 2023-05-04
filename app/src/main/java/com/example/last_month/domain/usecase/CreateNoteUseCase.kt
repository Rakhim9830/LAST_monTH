package com.example.last_month.domain.usecase

import com.example.last_month.domain.model.Note
import com.example.last_month.domain.repositories.NoteRepository

class CreateNoteUseCase(
    private val noteRepository: NoteRepository
) {
    fun creatrNote(note:Note) = noteRepository.createNote(note)
}