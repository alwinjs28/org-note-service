package org.note.repository;

import org.note.entity.Note;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
