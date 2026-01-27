package com.smarthire.backend.repository;

import com.smarthire.backend.entity.Resume;
import com.smarthire.backend.service.ResumeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

    @Query("SELECT r FROM Resume r WHERE LOWER(r.content) LIKE LOWER(CONCAT('%', :skill, '%'))")
    List<Resume> searchBySkill(String skill);

}
