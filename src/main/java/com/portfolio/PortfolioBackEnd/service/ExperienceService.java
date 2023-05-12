package com.portfolio.PortfolioBackEnd.service;

import com.portfolio.PortfolioBackEnd.model.Experience;
import com.portfolio.PortfolioBackEnd.repository.ExperienceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService implements IExperienceService {

    @Autowired
    public ExperienceRepository expRepo;

    @Override
    public List<Experience> loadExperience() {
        return expRepo.findAll();
    }

    @Override
    public ResponseEntity<Experience> createExperience(Experience exp) {
        Experience experience = expRepo.save(exp);
        return ResponseEntity.ok(experience);
    }

    @Override
    public void deleteExperience(Long id) {
        expRepo.deleteById(id);
    }

    @Override
    public ResponseEntity<Experience> updateExperience(@PathVariable Long id, @RequestBody Experience toUpdateExperience) {
        Experience experience = expRepo.findById(id).orElse(null);

        experience.setImgurl(toUpdateExperience.getImgurl());
        experience.setName(toUpdateExperience.getName());
        experience.setCompany(toUpdateExperience.getCompany());
        experience.setTime(toUpdateExperience.getTime());

        Experience updatedEducation = expRepo.save(experience);

        return ResponseEntity.ok(updatedEducation);
    }

}
