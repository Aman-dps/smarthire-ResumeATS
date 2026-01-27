package com.smarthire.backend.service;

import com.smarthire.backend.dto.JobRoleDto;
import com.smarthire.backend.mapper.JobRoleMapper;
import com.smarthire.backend.repository.JobRoleRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.smarthire.backend.entity.JobRole;


import java.util.List;

@Service
public class JobRoleService {
    private final JobRoleRepository jobRoleRepository;
    public JobRoleService(JobRoleRepository jobRoleRepository) {
        this.jobRoleRepository = jobRoleRepository;
    }

    public List<JobRoleDto> getAllJobs(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return jobRoleRepository.findAll(pageable).stream().map(JobRoleMapper::toDto).toList();
    }
    public JobRoleDto create(JobRoleDto  jobRoleDto) {
        JobRole saved= jobRoleRepository.save(JobRoleMapper.toEntity(jobRoleDto));
        return JobRoleMapper.toDto(saved);
    }
    }

