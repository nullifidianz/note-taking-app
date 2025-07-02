package com.nullifidianz.md_notes.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nullifidianz.md_notes.repository.NoteRepository;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import org.languagetool.JLanguageTool;
import org.languagetool.language.AmericanEnglish;
import com.nullifidianz.md_notes.model.Note;
import java.time.LocalDateTime;
import java.util.List;
import org.languagetool.rules.RuleMatch;
import java.nio.charset.StandardCharsets;

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    private final Parser parser = Parser.builder().build();
    private final HtmlRenderer renderer = HtmlRenderer.builder().build();
    private final JLanguageTool languageTool = new JLanguageTool(new AmericanEnglish());

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note createNote(MultipartFile file) throws Exception {
        String content = new String(file.getBytes(), StandardCharsets.UTF_8);
        Note note = new Note();
        note.setFileName(file.getOriginalFilename());
        note.setContent(content);
        note.setCreatedAt(LocalDateTime.now());
        return noteRepository.save(note);
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public String renderToHtml(Long id) {
        Note note = noteRepository.findById(id).orElseThrow();
        return renderer.render(parser.parse(note.getContent()));
    }

    /**
     * Realiza a checagem gramatical do conteúdo da nota usando LanguageTool.
     * 
     * @param id ID da nota a ser verificada
     * @return Lista de erros gramaticais encontrados
     * @throws Exception caso a nota não seja encontrada ou ocorra erro no
     *                   LanguageTool
     */
    public List<RuleMatch> checkGrammar(Long id) throws Exception {
        Note note = noteRepository.findById(id).orElseThrow();

        return languageTool.check(note.getContent());
    }
}
