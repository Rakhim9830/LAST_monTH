package com.example.last_month.domain.usecase

import com.example.last_month.domain.repositories.NoteRepository

class GetAllNotesUseCase(private val noteRepository: NoteRepository
) {
    fun getAllNotes() = noteRepository.getAllNotes()
}