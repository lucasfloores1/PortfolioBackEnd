package com.portfolio.PortfolioBackEnd.service;

import com.portfolio.PortfolioBackEnd.model.Skills;
import com.portfolio.PortfolioBackEnd.repository.SkillsRepository;
import com.portfolio.PortfolioBackEnd.service.ISkillsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class SkillsService implements ISkillsService{

    @Autowired
    private SkillsRepository skiRepo;
    
    @Override
    public List<Skills> loadSkills() {
        return skiRepo.findAll();
    }

    @Override
    public ResponseEntity<Skills> createSkills(Skills ski) {
        Skills skill = skiRepo.save(ski);
        return ResponseEntity.ok(ski);
    }

    @Override
    public void deleteSkills(Long id) {
        skiRepo.deleteById(id);
    }

    @Override
    public ResponseEntity<Skills> updateSkills(@PathVariable Long id,@RequestBody Skills toUpdateSkills) {
        Skills skill = skiRepo.findById(id).orElse(null);

        skill.setName               (toUpdateSkills.getName());
        skill.setColor              (toUpdateSkills.getColor());
        skill.setValue              (toUpdateSkills.getValue());

        Skills updatedSkills = skiRepo.save(skill);

        return ResponseEntity.ok(updatedSkills);
    }
}