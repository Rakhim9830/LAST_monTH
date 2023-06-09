package com.example.last_month.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.last_month.R
import com.example.last_month.databinding.FragmentListOfNoteBinding
import com.example.last_month.domain.model.Note
import com.example.last_month.presentation.base.BaseFragment
import com.example.last_month.presentation.ui.utils.UIState
import dagger.hilt.android.AndroidEntryPoint

@Suppress("UNREACHABLE_CODE")
@AndroidEntryPoint
class ListOfNoteFragment : BaseFragment() {
    private lateinit var binding: FragmentListOfNoteBinding
    private val viewModel by viewModels<ListOfNoteViewModel>()
    private lateinit var adapter: ListOfNoteAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListOfNoteBinding.inflate(inflater, container, false)
        return binding.root
        adapter = ListOfNoteAdapter(this::removeNote, this::editClick)
        binding.noteRv.adapter = adapter
        loadView()
    }



    override fun initClickers() {
        binding.addFab.setOnClickListener {
            findNavController().navigate(R.id.create)
        }
    }

    fun editClick(note: com.example.last_month.domain.model.Note, id: Int){
        findNavController().navigate(R.id.create, bundleOf(
            "note" to note,
            "id" to id
        ))
    }

    override fun loadView() {
        viewModel.getAllNotes()
        viewModel.getAllNoteState.collectState(state = {state->
            binding.progressBar.isVisible = state is UIState.Loading
        }, onSuccess = { data ->
            adapter = ListOfNoteAdapter(this::removeNote, this::editClick)
            binding.noteRv.adapter = adapter
            binding.progressBar.visibility = View.GONE
            adapter.addNotes(data)
        })
    }

    private fun removeNote(note: com.example.last_month.domain.model.Note, id: Int) {
        viewModel.removeNote(note)
        viewModel.removeNoteState.collectState(state = {state->
            binding.progressBar.isVisible = state is UIState.Loading
        }, onSuccess = { data ->
            loadView()
        })
    }
}