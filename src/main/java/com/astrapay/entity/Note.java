package com.astrapay.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Note {
    private Long id;
    private String title;
    private String content;
    private Date createdDate;

    public Note(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdDate = new Date();
    }
}
