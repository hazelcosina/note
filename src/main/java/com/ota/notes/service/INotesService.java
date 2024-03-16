package com.ota.notes.service;

import com.ota.notes.entity.Note;

import java.util.List;

public interface INotesService {

    Note saveNote(Note note);

    List<Note> getAllNotes();

    Note getNoteById(long id);

    Note update(Long id, Note note);

    void deleteNote(long id);

}
