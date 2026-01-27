package com.smarthire.backend.dto;

public class CandidateScore {
    private Long candidateId;
    private String name;
    private String email;
    private int score;

    public CandidateScore(Long candidateId, String name, String email, int score) {
        this.candidateId = candidateId;
        this.name = name;
        this.email = email;
        this.score = score;
    }
    public Long getCandidateId() {
        return candidateId;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public int getScore() {
        return score;
    }
}
