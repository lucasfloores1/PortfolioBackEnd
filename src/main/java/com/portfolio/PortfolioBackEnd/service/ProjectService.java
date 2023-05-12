package com.portfolio.PortfolioBackEnd.service;

import com.portfolio.PortfolioBackEnd.model.Project;
import com.portfolio.PortfolioBackEnd.repository.ProjectRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ProjectService implements IProjectService{

    @Autowired
    private ProjectRepository proRepo;
    
    @Override
    public List<Project> loadProject() {
        return proRepo.findAll();
    }

    @Override
    public ResponseEntity<Project> createProject(Project pro) {
        Project project = proRepo.save(pro);
        return ResponseEntity.ok(pro);
    }

    @Override
    public void deleteProject(Long id) {
        proRepo.deleteById(id);
    }

    @Override
    public ResponseEntity<Project> updateProject(@PathVariable Long id,@RequestBody Project toUpdateProject) {
        Project project = proRepo.findById(id).orElse(null);

        project.setName            (toUpdateProject.getName());
        project.setDescription     (toUpdateProject.getDescription());
        project.setLink             (toUpdateProject.getLink());

        Project updatedProject = proRepo.save(project);

        return ResponseEntity.ok(updatedProject);
    }
    
    
    
}
