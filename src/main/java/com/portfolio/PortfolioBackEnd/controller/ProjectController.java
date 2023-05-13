package com.portfolio.PortfolioBackEnd.controller;

import com.portfolio.PortfolioBackEnd.model.Project;
import com.portfolio.PortfolioBackEnd.service.ProjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin( origins = "https://portfoliofrontend-f9741.web.app/" )
@CrossOrigin( origins = "https://localhost:4200/" )
public class ProjectController {
    
    @Autowired
    private ProjectService proServ;
    
    @GetMapping ( "/project/load" )
    @ResponseBody
    public List<Project> loadProject(){
        return proServ.loadProject();
    }
    
    @PostMapping("/project/create")
    public ResponseEntity<Project> createInfo(@RequestBody Project pro) {
        ResponseEntity<Project> response;

        Project createdProject = proServ.createProject(pro).getBody();

        if (createdProject != null) {
            response = ResponseEntity.ok(createdProject);
        } else {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return response;
    }
    
    @DeleteMapping("/project/delete/{id}")
    public void deleteProject(@PathVariable Long id) {
        proServ.deleteProject(id);
    }
    
    @PutMapping("/project/update/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project toUpdateProject) {
        return proServ.updateProject(id, toUpdateProject);        
    }
}
