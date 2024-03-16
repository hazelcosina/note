package com.ota.notes.service;

import com.ota.notes.entity.Note;
import com.ota.notes.exception.NoteNotFoundException;
import com.ota.notes.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService implements INotesService {

    private NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note saveNote(Note note) {
        Date dateToday = new Date();
        note.setDateCreated(dateToday);
        return noteRepository.save(note);
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note getNoteById(long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException("Note with id " + id + " not found"));
    }

    @Override
    public Note update(Long id, Note note) {
        Note existingNote = noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException("Note with id " + id + " not found"));
        existingNote.setTitle(note.getTitle());
        existingNote.setContent(note.getContent());
        noteRepository.save(existingNote);
        return existingNote;
    }

    @Override
    public void deleteNote(long id) {
        noteRepository.deleteById(id);
    }


}
