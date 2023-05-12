package com.portfolio.PortfolioBackEnd.controller;

import com.portfolio.PortfolioBackEnd.model.Skills;
import com.portfolio.PortfolioBackEnd.service.SkillsService;
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
@CrossOrigin( origins = "http://localhost:4200" )
public class SkillsController {
    
    @Autowired
    private SkillsService skiServ;
    
    @GetMapping ( "/skills/load" )
    @ResponseBody
    public List<Skills> loadSkills(){
        return skiServ.loadSkills();
    }
    
    @PostMapping("/skills/create")
    public ResponseEntity<Skills> createInfo(@RequestBody Skills ski) {
        ResponseEntity<Skills> response;

        Skills createdSkills = skiServ.createSkills(ski).getBody();

        if (createdSkills != null) {
            response = ResponseEntity.ok(createdSkills);
        } else {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return response;
    }
    
    @DeleteMapping("/skills/delete/{id}")
    public void deleteSkills(@PathVariable Long id) {
        skiServ.deleteSkills(id);
    }
    
    @PutMapping("/skills/update/{id}")
    public ResponseEntity<Skills> updateSkills(@PathVariable Long id, @RequestBody Skills toUpdateSkills) {
        return skiServ.updateSkills(id, toUpdateSkills);        
    }
}