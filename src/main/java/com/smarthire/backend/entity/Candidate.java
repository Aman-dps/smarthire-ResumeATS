package com.smarthire.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    @OneToOne
    Resume resume;
    public Candidate(String name, String email, Resume resume) {
        this.name = name;
        this.email = email;
        this.resume = resume;
    }
/*
    public Candidate() {
    }



    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public Resume getResume() {
        return resume;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
*/
}
