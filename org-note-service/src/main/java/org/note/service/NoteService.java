package org.note.service;

import org.note.error.BadRequestException;
import org.note.error.NoteNotFoundException;
import org.note.entity.Note;
import org.note.model.NoteDto;
import org.note.repository.NoteRepository;
import org.note.util.NoteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.note.util.NoteConstants.INPUT_REQUEST_MANDATORY;
import static org.note.util.NoteConstants.NOTE_NOT_FOUND;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public void createNote(NoteDto noteDto) {
        if(noteDto == null) {
            throw new BadRequestException(INPUT_REQUEST_MANDATORY);
        }
        Note note = NoteUtil.convertToNote(noteDto);
        noteRepository.save(note);
    }

    public NoteDto getNote(Long id) {
        Optional<Note> noteOptional = noteRepository.findById(id);
        if (noteOptional.isEmpty()) {
            throw new NoteNotFoundException(String.format(NOTE_NOT_FOUND, id));
        }
        return NoteUtil.convertToNoteDto(noteOptional.get());
    }

    public List<NoteDto> getAllNotes() {
        List<Note> noteList = noteRepository.findAll();
        return noteList.stream().map(NoteUtil::convertToNoteDto).collect(Collectors.toList());
    }

    public NoteDto updateNote(Long id, NoteDto noteDto) {
        if(noteDto == null) {
            throw new BadRequestException(INPUT_REQUEST_MANDATORY);
        }
        Optional<Note> noteOptional = noteRepository.findById(id);
        if(noteOptional.isEmpty()) {
            throw new NoteNotFoundException(String.format(NOTE_NOT_FOUND, id));
        }
        Note note = noteOptional.get();
        note.setTitle(noteDto.getTitle() != null ? noteDto.getTitle() : note.getTitle());
        note.setContent(noteDto.getContent() != null ? noteDto.getContent() : note.getContent());
        Note updatedNote = noteRepository.save(note);

        return NoteUtil.convertToNoteDto(updatedNote);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}
