package com.example.last_month.presentation.ui.fragments

import androidx.lifecycle.ViewModel
import com.example.last_month.domain.model.Note
import com.example.last_month.domain.usecase.GetAllNoteUseCase
import com.example.last_month.domain.usecase.RemoveNoteUseCase
import com.example.last_month.presentation.base.BaseViewModel
import com.example.last_month.presentation.ui.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class ListOfNoteViewModel @Inject constructor(
    private val getAllNoteUseCase: GetAllNoteUseCase,
    private val removeNoteUseCase: RemoveNoteUseCase
) : BaseViewModel() {
    private val _getAllNoteState = MutableStateFlow<UIState<List<Note>>>(UIState.Empty())
    val getAllNoteState = _getAllNoteState.asStateFlow()

    private val _removeNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val removeNoteState = _removeNoteState.asStateFlow()

    fun getAllNotes() {
        getAllNoteUseCase.getAllNotes().collectData(_getAllNoteState)
    }
    fun removeNote(note: Note) {
        removeNoteUseCase.removeNote(note).collectData(_removeNoteState)
    }
}