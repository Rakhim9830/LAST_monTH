package com.example.last_month.presentation.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.last_month.databinding.NoteItemBinding
import com.example.last_month.domain.model.Note

class ListOfNoteAdapter(private val removeClick: (com.example.last_month.domain.model.Note, Int) -> Unit, private val editClick:(com.example.last_month.domain.model.Note, Int)->Unit)  : RecyclerView.Adapter<ListOfNoteAdapter.ListOfNoteHolder>() {
    private var data = arrayListOf<com.example.last_month.domain.model.Note>()
    fun addNotes(list: List<com.example.last_month.domain.model.Note>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListOfNoteHolder {
        return ListOfNoteHolder(
            NoteItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ListOfNoteHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ListOfNoteHolder(private val binding: NoteItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(note: com.example.last_month.domain.model.Note) {
            binding.tvTitle.text = note.title
            binding.tvDesc.text = note.desc
            itemView.setOnLongClickListener {
                removeClick(note,adapterPosition)
                false
            }
            itemView.setOnClickListener{
                editClick(note, adapterPosition)
            }
        }

    }

}