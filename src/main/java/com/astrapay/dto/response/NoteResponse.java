package com.astrapay.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class NoteResponse {
    private Long id;

    private String title;

    private String content;

    private Date createdDate;
}
