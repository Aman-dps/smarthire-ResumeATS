package com.smarthire.backend.controller;

import com.smarthire.backend.dto.CandidateScore;
import com.smarthire.backend.dto.RankingRequestDto;
import com.smarthire.backend.entity.Candidate;
import com.smarthire.backend.service.CandidateService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {
    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/search")
    public List<Candidate> search(@RequestParam String skill) {
        return candidateService.searchBySkill(skill);
    }

    @PostMapping("/rank")
    public List<CandidateScore> rank(@RequestBody RankingRequestDto request) {
        return candidateService.rankBySkills(request.getSkills());
    }
}
