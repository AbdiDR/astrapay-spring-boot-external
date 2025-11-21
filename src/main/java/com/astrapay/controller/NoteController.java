package com.astrapay.controller;

import com.astrapay.dto.request.NoteRequest;
import com.astrapay.dto.response.BaseResponse;
import com.astrapay.dto.response.NoteResponse;
import com.astrapay.service.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/notes")

public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public ResponseEntity<BaseResponse<List<NoteResponse>>> getAllNotes() {
        return ResponseEntity.ok(new BaseResponse<>(
                200,
                "Notes retrieved successfully",
                noteService.getAllNotes()
        ));
    }

    @PostMapping
    public ResponseEntity<BaseResponse<NoteResponse>> createNote(@Valid @RequestBody NoteRequest request) {
        return ResponseEntity.ok(new BaseResponse<>(
                200,
                "Note created successfully",
                noteService.addNote(request)
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<Void>> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return ResponseEntity.ok().body(new BaseResponse<>(
                200,
                "Note deleted successfully",
                null
        ));
    }
}
