package com.smarthire.backend.service;

import com.smarthire.backend.dto.CandidateScore;
import com.smarthire.backend.dto.SkillWeightDto;
import com.smarthire.backend.entity.Candidate;
import com.smarthire.backend.entity.Resume;
import com.smarthire.backend.repository.CandidateRepository;
import com.smarthire.backend.repository.ResumeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import lombok.Data;

@Data
@Service
public class CandidateService {
    private static final Logger log = LoggerFactory.getLogger(CandidateService.class);

    private final CandidateRepository candidateRepository;
    private final ResumeRepository resumeRepository;

    public CandidateService(CandidateRepository candidateRepository, ResumeRepository resumeRepository) {
        this.candidateRepository = candidateRepository;
        this.resumeRepository = resumeRepository;
    }

    public List<Candidate> searchBySkill(String skill) {
        log.info("Services: Searching resumes for skill: {}", skill);
        List<Resume> resumes = resumeRepository.searchBySkill(skill);
        log.info("Found {} resumes matching skill '{}'", resumes.size(), skill);
        return resumes.stream()
                .map(r -> candidateRepository.findByResume(r)).toList();
    }

    public List<CandidateScore> rankBySkills(List<SkillWeightDto> skills) {
        log.info("Services: Starting ranking process for {} skills", skills.size());

        List<Candidate> allCandidates = candidateRepository.findAll();
        log.info("Fetched {} total candidates for processing", allCandidates.size());

        List<CandidateScore> scoredCandidates = allCandidates.stream()
                .map(candidate -> {
                    String resumeText = candidate.getResume().getContent();
                    log.debug("Processing candidate: {} (ID: {})", candidate.getName(), candidate.getId());

                    int totalScore = calculatedWeightedScore(resumeText, skills, candidate.getName());

                    log.info("Calculated score for {}: {}", candidate.getName(), totalScore);
                    return new CandidateScore(
                            candidate.getResume().getId(),
                            candidate.getName(),
                            candidate.getEmail(), totalScore);
                })
                .sorted((a, b) -> Integer.compare(b.getScore(), a.getScore())).toList();

        log.info("Ranking process completed.");
        return scoredCandidates;
    }

    private int calculatedWeightedScore(String content, List<SkillWeightDto> skills, String candidateName) {
        if (content == null) {
            log.warn("Resume content is null for candidate: {}", candidateName);
            return 0;
        }

        String text = content.toLowerCase();
        int score = 0;

        for (SkillWeightDto skill : skills) {
            String key = skill.getName().toLowerCase();
            int weight = skill.getWeight();

            // Note: simple split counting can be inaccurate for edge cases but keeping
            // original logic
            int matches = text.split(key, -1).length - 1;

            if (matches > 0) {
                int points = matches * 10 * weight;
                score += points;
                log.debug("  - Skill '{}' found {} times. Weight: {}. Points: {}", key, matches, weight, points);
            }
        }

        return score;
    }
}
