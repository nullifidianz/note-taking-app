package com.nullifidianz.md_notes.controller;

import org.springframework.web.bind.annotation.RestController;
import com.nullifidianz.md_notes.service.NoteService;
import org.springframework.web.bind.annotation.*;
import com.nullifidianz.md_notes.model.Note;
import org.springframework.http.*;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import org.languagetool.rules.RuleMatch;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteService service;

    public NoteController(NoteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Note> upload(@RequestParam("file") MultipartFile file) throws Exception {
        return ResponseEntity.ok(service.createNote(file));
    }

    @GetMapping
    public ResponseEntity<List<Note>> list() {
        return ResponseEntity.ok(service.getAllNotes());
    }

    @GetMapping("/{id}/render")
    public ResponseEntity<String> render(@PathVariable Long id) {
        return ResponseEntity.ok(service.renderToHtml(id));
    }

    @GetMapping("/{id}/grammar")
    public ResponseEntity<List<RuleMatch>> grammar(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(service.checkGrammar(id));
    }
}
