package com.astrapay.service.impl;

import com.astrapay.dto.request.NoteRequest;
import com.astrapay.dto.response.NoteResponse;
import com.astrapay.entity.Note;
import com.astrapay.exception.CustomException;
import com.astrapay.service.NoteService;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class NoteServiceImpl implements NoteService {

    private static final List<Note> IN_MEMORY_NOTES = new ArrayList<>();

    private static final AtomicLong ID_GENERATOR = new AtomicLong(0);

    @Override
    public NoteResponse addNote(NoteRequest request) {
        Long newId = ID_GENERATOR.incrementAndGet();

        Note newNote = new Note(
                newId,
                request.getTitle(),
                request.getContent()
        );
        IN_MEMORY_NOTES.add(newNote);
        return new NoteResponse(
                newNote.getId(),
                newNote.getTitle(),
                newNote.getContent(),
                newNote.getCreatedDate()
        );
    }

    @Override
    public List<NoteResponse> getAllNotes() {
        return IN_MEMORY_NOTES.stream()
                .map(note -> new NoteResponse(
                        note.getId(),
                        note.getTitle(),
                        note.getContent(),
                        note.getCreatedDate()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteNote(Long id) {
        boolean removed = IN_MEMORY_NOTES.removeIf(note -> note.getId().equals(id));

        if (!removed) {
            throw new CustomException(
                    "Note with id: " + id + " is Not Found",
                    HttpStatus.NOT_FOUND,
                    404
            );
        }
    }
}
