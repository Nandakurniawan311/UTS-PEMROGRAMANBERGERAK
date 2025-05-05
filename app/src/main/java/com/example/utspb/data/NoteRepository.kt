package com.example.utspb.data

import com.example.utspb.model.Note

interface NoteRepository {
    fun addNote(note: Note)
    fun getNotes(): List<Note>
}

class NoteRepositoryImpl : NoteRepository {
    private val notes = mutableListOf<Note>()
    override fun addNote(note: Note) {
        notes.add(note)
    }
    override fun getNotes(): List<Note> = notes
}
