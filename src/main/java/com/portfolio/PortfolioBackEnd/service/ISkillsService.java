package com.portfolio.PortfolioBackEnd.service;

import com.portfolio.PortfolioBackEnd.model.Skills;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


public interface ISkillsService {
    
    public List<Skills> loadSkills();

    public  ResponseEntity<Skills> createSkills(Skills ski);

    public void deleteSkills(Long id);

    public ResponseEntity<Skills> updateSkills(@PathVariable Long id, @RequestBody Skills toUpdateSkills);
    
}
