package com.example.noteit.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.noteit.databinding.NotesLayoutBinding
import com.example.noteit.model.Note

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder> (){

    class NoteViewHolder(val itemBinding:NotesLayoutBinding): RecyclerView.ViewHolder(itemBinding.root)

    private val differCallback = object: DiffUtil.ItemCallback<Note>(){
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id==newItem.id &&
                    oldItem.noteDecs == newItem.noteDecs &&
                    oldItem.noteTitle == newItem.noteTitle
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this,differCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapter.NoteViewHolder {
        return NoteViewHolder(
            NotesLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: NoteAdapter.NoteViewHolder, position: Int) {
        val currentNote = differ.currentList[position]
        holder.itemBinding.noteTitle.text=currentNote.noteTitle
        holder.itemBinding.noteDesc.text=currentNote.noteDecs

    }

    override fun getItemCount(): Int {

    }
}