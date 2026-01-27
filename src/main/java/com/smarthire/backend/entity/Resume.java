package com.smarthire.backend.entity;

import jakarta.persistence.*;

@Entity
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String filename;

    @Column(columnDefinition = "TEXT")
    private String content;

    public Resume() {
    }

    public Resume(String filename, String content) {
        this.filename = filename;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
