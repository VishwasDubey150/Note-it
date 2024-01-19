package com.example.noteit.repository

import androidx.room.Query
import com.example.noteit.Database.NoteDatabase
import com.example.noteit.model.Note

class NoteRepository(private val db:NoteDatabase) {
    suspend fun insertNote(note: Note) = db.getNoteDao().instertNote(note)
    suspend fun deleteNote(note: Note) = db.getNoteDao().deleteNote(note)
    suspend fun updateNote(note: Note) = db.getNoteDao().updateNote(note)

    fun getAllNotes()= db.getNoteDao().getAllNote()
    fun searchNote(query: String?)= db.getNoteDao().searchNotes(query)
}