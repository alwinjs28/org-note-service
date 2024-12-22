package org.note.error;

public class NoteNotFoundException extends RuntimeException{
    public NoteNotFoundException(String message) {
        super(message);
    }
}
