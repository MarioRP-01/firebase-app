package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private final ProjectRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<ProjectEntity> getMethodName(@PathVariable("id") Integer projectId) {
        var result = repository.findById(projectId);
        
        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
}
