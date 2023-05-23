package com.example.last_month.domain.usecase

import com.example.last_month.domain.model.Note
import com.example.last_month.domain.repositories.NoteRepository
import javax.inject.Inject

class RemoveNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
){

    fun removeNote(note: Note) = noteRepository.removeNote(note)
}