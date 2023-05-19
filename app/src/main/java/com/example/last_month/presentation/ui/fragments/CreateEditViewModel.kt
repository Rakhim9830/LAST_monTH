package com.example.last_month.presentation.ui.fragment

import androidx.lifecycle.ViewModel
import com.example.last_month.domain.model.Note
import com.example.last_month.domain.usecase.CreateNoteUseCase
import com.example.last_month.domain.usecase.EditNoteUseCase
import com.example.last_month.presentation.base.BaseViewModel
import com.example.last_month.presentation.ui.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CreateEditViewModel @Inject constructor(
    private val editNoteUseCase: EditNoteUseCase,
    private val createNoteUseCase: CreateNoteUseCase
) : BaseViewModel() {
    private val _editNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val editNoteState = _editNoteState.asStateFlow()

    private val _createNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val createNoteState = _createNoteState.asStateFlow()

    fun editNote(note: Note) {
        editNoteUseCase.editNote(note).collectData(_editNoteState)
    }
    fun createNote(note: Note) {
        createNoteUseCase.createNote(note).collectData(_createNoteState)
    }
}