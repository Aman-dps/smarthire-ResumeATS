package com.smarthire.backend.controller;

import com.smarthire.backend.dto.JobRoleDto;
import com.smarthire.backend.entity.JobRole;
import com.smarthire.backend.service.JobRoleService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobRoleController {
    private final JobRoleService jobRoleService;
    public JobRoleController(JobRoleService jobRoleService) {
        this.jobRoleService = jobRoleService;
    }
    @GetMapping
    public List<JobRoleDto> getAllJobs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sort
    ) {
        return jobRoleService.getAllJobs(page, size, sort);
    }

    @PostMapping
    public JobRoleDto create(@Valid @RequestBody JobRoleDto jobRoleDto) {
        return jobRoleService.create(jobRoleDto);
    }
}
