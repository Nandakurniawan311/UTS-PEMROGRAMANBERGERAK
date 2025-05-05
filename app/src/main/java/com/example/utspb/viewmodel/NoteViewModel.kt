package com.example.utspb.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.utspb.data.NoteRepositoryImpl
import com.example.utspb.model.Note
import com.example.utspb.usecase.AddNoteUseCase
import com.example.utspb.usecase.GetNotesUseCase

class NoteViewModel : ViewModel() {
    private val repository = NoteRepositoryImpl()
    private val addNoteUseCase = AddNoteUseCase(repository)
    private val getNotesUseCase = GetNotesUseCase(repository)

    private val _notes = mutableStateListOf<Note>()
    val notes: List<Note> get() = _notes

    init {
        loadNotes()
    }

    fun addNote(content: String) {
        if (content.isNotBlank()) {
            addNoteUseCase(Note(content))
            loadNotes()
        }
    }

    private fun loadNotes() {
        _notes.clear()
        _notes.addAll(getNotesUseCase())
    }
}
