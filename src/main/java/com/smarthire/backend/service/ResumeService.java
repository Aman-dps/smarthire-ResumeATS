package com.smarthire.backend.service;

import com.smarthire.backend.entity.Candidate;
import com.smarthire.backend.entity.Resume;

import com.smarthire.backend.repository.CandidateRepository;
import com.smarthire.backend.repository.ResumeRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ResumeService {
    private static final Logger log = LoggerFactory.getLogger(ResumeService.class);
    private final ResumeRepository resumeRepository;
    private final CandidateRepository candidateRepository;
    private final Tika tika = new Tika();

    public ResumeService(ResumeRepository resumeRepository, CandidateRepository candidateRepository) {
        this.resumeRepository = resumeRepository;
        this.candidateRepository = candidateRepository;
    }

    public Candidate upload(MultipartFile file, String name, String email) throws IOException, TikaException {
        String text = tika.parseToString(file.getInputStream());
        log.info(text);

        Resume resume = resumeRepository.save((new Resume(file.getOriginalFilename(), text)));

        Candidate existingCandidate = candidateRepository.findByEmail(email);
        if (existingCandidate != null) {
            existingCandidate.setResume(resume);
            return candidateRepository.save(existingCandidate);

        } else {
            Candidate candidate = new Candidate(name, email, resume);
            return candidateRepository.save(candidate);

        }

    }

    // public Resume upload(MultipartFile file) throws IOException,TikaException {
    // String text=tika.parseToString(file.getInputStream());
    // Resume resume=new Resume(file.getOriginalFilename(),text);
    // return resumeRepository.save(resume);
    // }
}
