package com.example.last_month.presentation.ui.fragments

import com.example.last_month.domain.model.Note
import com.example.last_month.domain.usecase.GetAllNoteUseCase
import com.example.last_month.domain.usecase.RemoveNoteUseCase
import com.example.last_month.presentation.ui.utils.UIState
import com.example.lesson1month8.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class ListOfNoteViewModel @Inject constructor(
    private val getAllNoteUseCase: com.example.last_month.domain.usecase.GetAllNoteUseCase,
    private val removeNoteUseCase: com.example.last_month.domain.usecase.RemoveNoteUseCase
) : BaseViewModel() {
    private val _getAllNoteState = MutableStateFlow<UIState<List<com.example.last_month.domain.model.Note>>>(UIState.Empty())
    val getAllNoteState = _getAllNoteState.asStateFlow()

    private val _removeNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val removeNoteState = _removeNoteState.asStateFlow()

    fun getAllNotes() {
        getAllNoteUseCase.getAllNotes().collectData(_getAllNoteState)
    }
    fun removeNote(note: com.example.last_month.domain.model.Note) {
        removeNoteUseCase.removeNote(note).collectData(_removeNoteState)
    }
}