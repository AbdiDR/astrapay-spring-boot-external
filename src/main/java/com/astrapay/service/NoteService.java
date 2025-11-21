package com.astrapay.service;

import com.astrapay.dto.request.NoteRequest;
import com.astrapay.dto.response.NoteResponse;
import com.astrapay.entity.Note;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    NoteResponse addNote(NoteRequest request);
    List<NoteResponse> getAllNotes();
    void deleteNote(Long id);
}
