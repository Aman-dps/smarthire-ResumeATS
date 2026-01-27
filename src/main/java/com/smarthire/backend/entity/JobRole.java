package com.smarthire.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "job_roles")
public class JobRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    public JobRole() {}
    public JobRole(String title, String description) {
        this.title = title;
        this.description = description;
    }
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
}
