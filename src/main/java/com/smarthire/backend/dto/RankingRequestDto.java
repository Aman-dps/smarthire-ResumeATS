package com.smarthire.backend.dto;

import java.util.List;

public class RankingRequestDto {
    private List<SkillWeightDto> skillWeights;
    public List<SkillWeightDto> skills;
    public RankingRequestDto() {}
    public List<SkillWeightDto> getSkills() {
        return skills;
    }

}
