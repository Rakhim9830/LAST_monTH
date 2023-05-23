package com.example.last_month.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.last_month.domain.model.Note
import com.example.last_month.presentation.base.BaseFragment
import com.example.last_month.presentation.ui.fragment.CreateEditViewModel
import com.example.last_month.presentation.ui.utils.UIState
import dagger.hilt.android.AndroidEntryPoint
import com.example.last_month.databinding.FragmentCreateEditBinding as FragmentCreateEditBinding


@AndroidEntryPoint
class CreateEditFragment : BaseFragment() {

    private lateinit var binding: FragmentCreateEditBinding
    private val viewModel by viewModels<CreateEditViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    override fun initClickers() {
        binding.createEditBtn.setOnClickListener {
            if (arguments?.getInt("id") != null) {
                var note = arguments?.getSerializable("note") as com.example.last_month.domain.model.Note
                note.title = binding.titleEt.text.toString()
                note.desc = binding.descEt.text.toString()
                editNote(note = note)
                findNavController().navigateUp()
            } else {
                createNote(
                    Note(
                        title = binding.titleEt.text.toString(),
                        desc = binding.descEt.text.toString()
                    )
                )
                findNavController().navigateUp()
            }
        }
    }


    private fun createNote(note: com.example.last_month.domain.model.Note) {
        viewModel.createNote(note)
        viewModel.createNoteState.collectState(state = { state ->
            binding.progressBar.isVisible = state is UIState.Loading
        }, onSuccess = {

        })
    }

    private fun editNote(note: Note) {
        viewModel.editNote(note)
        viewModel.editNoteState.collectState(state = { state ->
            binding.progressBar.isVisible = state is UIState.Loading
        }, onSuccess = { data ->

        })
    }

}