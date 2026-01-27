package com.smarthire.backend.mapper;

import com.smarthire.backend.dto.JobRoleDto;
import com.smarthire.backend.entity.JobRole;

public class JobRoleMapper {
    public static JobRole toEntity(JobRoleDto jobRoleDto) {
        return new JobRole(jobRoleDto.getTitle(), jobRoleDto.getDescription());
    }
    public static JobRoleDto toDto(JobRole jobRole) {
        return  new JobRoleDto(jobRole.getId(),jobRole.getTitle(),jobRole.getDescription());
    }
}
