package com.example.last_month.domain.usecase

import com.example.last_month.domain.repositories.NoteRepository
import javax.inject.Inject

class GetAllNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
){
    fun getAllNotes() = noteRepository.getAllNotes()
}