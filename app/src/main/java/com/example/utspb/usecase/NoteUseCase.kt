package com.example.utspb.usecase

import com.example.utspb.data.NoteRepository
import com.example.utspb.model.Note

class AddNoteUseCase(private val repository: NoteRepository) {
    operator fun invoke(note: Note) = repository.addNote(note)
}

class GetNotesUseCase(private val repository: NoteRepository) {
    operator fun invoke(): List<Note> = repository.getNotes()
}
