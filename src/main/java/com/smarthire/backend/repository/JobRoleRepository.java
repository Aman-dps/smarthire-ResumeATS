package com.smarthire.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smarthire.backend.entity.JobRole;


public interface JobRoleRepository extends JpaRepository<JobRole, Long> {
}
