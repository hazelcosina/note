package com.ota.notes.controller;

import com.ota.notes.entity.Note;
import com.ota.notes.service.INotesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * Controller class for managing notes.
 */
@RestController
@RequestMapping("/notes")
public class NotesController {

    private static final Logger log = LoggerFactory.getLogger(NotesController.class);

    private final INotesService noteService;

    public NotesController(INotesService noteService) {
        this.noteService = noteService;
    }

    /**
     * Retrieves all notes.
     *
     * @return ResponseEntity with a list of notes and HttpStatus OK if successful.
     */
    @GetMapping()
    public ResponseEntity<List<Note>> getAllNotes() {
        List<Note> notes = noteService.getAllNotes();
        return ResponseEntity.ok(notes);
    }

    /**
     * Retrieves a note by its ID.
     *
     * @param id The ID of the note to retrieve.
     * @return ResponseEntity with the retrieved note
     */
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        Note note = noteService.getNoteById(id);
        return ResponseEntity.ok(note);
    }

    /**
     * Creates a new note.
     *
     * @param note The note object to create.
     * @return ResponseEntity with the created note and HttpStatus CREATED if successful, or HttpStatus BAD_REQUEST if the input data is invalid.
     */
    @PostMapping()
    public ResponseEntity<?> createNote(@RequestBody @Valid Note note) {
        return new ResponseEntity<Note>(noteService.saveNote(note), HttpStatus.CREATED);
    }

    /**
     * Updates an existing note.
     *
     * @param id   The ID of the note to update.
     * @param note The updated note object.
     * @return ResponseEntity with the updated note and HttpStatus OK if successful, or HttpStatus NOT_FOUND if the note is not found, or HttpStatus BAD_REQUEST if the input data is invalid.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @Valid @RequestBody Note note) {
        Note updatedNote = noteService.update(id, note);
        return ResponseEntity.ok(updatedNote);
    }

    /**
     * Deletes a note by its ID.
     *
     * @param id The ID of the note to delete.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNoteById(@PathVariable Long id) {
        noteService.deleteNote(id);
        return ResponseEntity.noContent().build();
    }

}
