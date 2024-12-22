package org.note.util;

import org.note.entity.Note;
import org.note.model.NoteDto;
import org.springframework.beans.BeanUtils;

public class NoteUtil {
    public static NoteDto convertToNoteDto(Note note) {
        NoteDto noteDto = new NoteDto();
        if(noteDto != null) {
            BeanUtils.copyProperties(note, noteDto);
        }
        return noteDto;
    }
    public static Note convertToNote(NoteDto noteDto) {
        Note note = new Note();
        if(noteDto != null) {
            BeanUtils.copyProperties(noteDto, note);
        }
        return note;
    }
}
