package com.nullifidianz.md_notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nullifidianz.md_notes.model.Note;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Long> {
    Optional<Note> findByFileName(String fileName);

}
