package org.note.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.note.model.NoteDto;
import org.note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping("/api/notes")
    @Operation(
            summary = "Create a new note with a title and content.",
            description = "This endpoint allows users to create a new note by providing the necessary note details (title, content, etc.) in the request body."
    )
    public ResponseEntity<Void> createNote(@RequestBody NoteDto noteDto) {
        noteService.createNote(noteDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/api/notes/{id}")
    @Operation(
            summary = "Retrieve a single note.",
            description = "Retrieve a single note by its ID."
    )
    public ResponseEntity<NoteDto> getNote(@PathVariable Long id) {
        NoteDto noteDto = noteService.getNote(id);
        return new ResponseEntity<>(noteDto, HttpStatus.OK);
    }

    @GetMapping("/api/notes")
    @Operation(
            summary = "Retrieve all the available notes.",
            description = "Retrieve a list of all available notes."
    )
    public ResponseEntity<List<NoteDto>> getAllNotes() {
        List<NoteDto> noteDtos = noteService.getAllNotes();
        return new ResponseEntity<>(noteDtos, HttpStatus.OK);
    }

    @PutMapping("/api/notes/{id}")
    @Operation(
            summary = "Update the title and content of an existing note.",
            description = "Update the title and content of an existing note by providing its ID."
    )
    public ResponseEntity<NoteDto> updateNote(@PathVariable Long id, @RequestBody NoteDto noteDto) {
        NoteDto updatedNote = noteService.updateNote(id, noteDto);
        return new ResponseEntity<>(updatedNote, HttpStatus.OK);
    }

    @DeleteMapping("/api/notes/{id}")
    @Operation(
            summary = "Delete a note by its ID.",
            description = "Delete a note by its ID."
    )
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
