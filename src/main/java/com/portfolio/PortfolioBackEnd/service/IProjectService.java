package com.portfolio.PortfolioBackEnd.service;

import com.portfolio.PortfolioBackEnd.model.Project;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface IProjectService {
    
    public List<Project> loadProject();

    public  ResponseEntity<Project> createProject(Project pro);

    public void deleteProject(Long id);

    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project toUpdateProject);

    
}
