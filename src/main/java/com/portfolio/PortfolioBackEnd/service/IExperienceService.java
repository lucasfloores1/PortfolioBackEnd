package com.portfolio.PortfolioBackEnd.service;

import com.portfolio.PortfolioBackEnd.model.Experience;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface IExperienceService {

    public List<Experience> loadExperience();

    public ResponseEntity<Experience> createExperience(Experience exp);

    public void deleteExperience(Long id);

    public ResponseEntity<Experience> updateExperience(@PathVariable Long id, @RequestBody Experience toUpdateExperience);

}
