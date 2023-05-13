package com.portfolio.PortfolioBackEnd.controller;

import com.portfolio.PortfolioBackEnd.model.Education;
import com.portfolio.PortfolioBackEnd.service.EducationService;
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
public class EducationController {

    @Autowired
    private EducationService eduServ;


    @GetMapping("/education/load")
    @ResponseBody
    public List<Education> loadEducation() {
        return eduServ.loadEducation();
    }

    @PostMapping("/education/create")
    public ResponseEntity<Education> createEducation(@RequestBody Education edu) {
        ResponseEntity<Education> response;

        Education createdEducation = eduServ.createEducation(edu).getBody();

        if (createdEducation != null) {
            response = ResponseEntity.ok(createdEducation);
        } else {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return response;
    }

    @DeleteMapping("/education/delete/{id}")
    public void deleteEducation(@PathVariable Long id) {
        eduServ.deleteEducation(id);
    }
 
   
    @PutMapping("/education/update/{id}")
    public ResponseEntity<Education> updateEducation(@PathVariable Long id, @RequestBody Education toUpdateEducation) {
        return eduServ.updateEducation(id, toUpdateEducation);
    }
}
