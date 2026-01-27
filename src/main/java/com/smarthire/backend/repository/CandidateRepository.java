package com.smarthire.backend.repository;

import com.smarthire.backend.entity.Candidate;
import com.smarthire.backend.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    Candidate findByResume(Resume resume);
    Candidate findByName(String name);
    Candidate findByEmail(String email);

}
