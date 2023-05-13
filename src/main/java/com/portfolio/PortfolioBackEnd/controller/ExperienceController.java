package com.portfolio.PortfolioBackEnd.controller;

import com.portfolio.PortfolioBackEnd.model.Experience;
import com.portfolio.PortfolioBackEnd.service.ExperienceService;
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
public class ExperienceController {

    @Autowired
    private ExperienceService expServ;

    @GetMapping("/experience/load")
    @ResponseBody
    public List<Experience> loadExperience() {
        return expServ.loadExperience();
    }

    @PostMapping("/experience/create")
    public ResponseEntity<Experience> createEducation(@RequestBody Experience exp) {
        ResponseEntity<Experience> response;

        Experience createdExperience = expServ.createExperience(exp).getBody();

        if (createdExperience != null) {
            response = ResponseEntity.ok(createdExperience);
        } else {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return response;
    }

    @DeleteMapping("/experience/delete/{id}")
    public void deleteExperience(@PathVariable Long id) {
        expServ.deleteExperience(id);
    }

    @PutMapping("/experience/update/{id}")
    public ResponseEntity<Experience> updateExperience(@PathVariable Long id, @RequestBody Experience toUpdateExperience) {
        return expServ.updateExperience(id, toUpdateExperience);
    }

}
