package com.portfolio.PortfolioBackEnd.service;

import com.portfolio.PortfolioBackEnd.model.Education;
import com.portfolio.PortfolioBackEnd.repository.EducationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EducationService implements IEducationService {

    @Autowired
    public EducationRepository eduRepo;

    @Override
    public List<Education> loadEducation() {
        return eduRepo.findAll();
    }

    @Override
    public ResponseEntity<Education> createEducation(Education edu) {
        Education education = eduRepo.save(edu);
        return ResponseEntity.ok(education);
    }

    @Override
    public void deleteEducation(Long id) {
        eduRepo.deleteById(id);
    }

    @Override
    public ResponseEntity<Education> updateEducation(@PathVariable Long id, @RequestBody Education toUpdateEducation) {
        Education education = eduRepo.findById(id).orElse(null);

        education.setImgurl     (toUpdateEducation.getImgurl());
        education.setInstitute  (toUpdateEducation.getInstitute());
        education.setTitle      (toUpdateEducation.getTitle());
        education.setTime       (toUpdateEducation.getTime());

        Education updatedEducation = eduRepo.save(education);

        return ResponseEntity.ok(updatedEducation);
    }

}
