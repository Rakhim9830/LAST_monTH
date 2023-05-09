package com.example.last_month.data.mappers

import com.example.last_month.data.model.NoteEntity
import com.example.last_month.domain.model.Note

fun Note.toEntity() = NoteEntity(id, title, desc)

fun NoteEntity.toNote() = Note(id, title, desc)