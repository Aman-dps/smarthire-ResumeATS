package com.smarthire.backend.controller;

import com.smarthire.backend.entity.Candidate;
import com.smarthire.backend.entity.Resume;
import com.smarthire.backend.service.ResumeService;
import org.apache.tika.exception.TikaException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/resumes")
public class ResumeController {
    private final ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping("/upload")
    public Candidate upload(@RequestParam("file") MultipartFile file,
            @RequestParam String name,
            @RequestParam String email) throws IOException, TikaException {
        return resumeService.upload(file, name, email);
    }
}
