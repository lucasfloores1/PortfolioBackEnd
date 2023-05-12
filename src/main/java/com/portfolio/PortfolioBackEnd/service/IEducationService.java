package com.portfolio.PortfolioBackEnd.service;

import com.portfolio.PortfolioBackEnd.model.Education;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


public interface IEducationService {

    public List<Education> loadEducation();

    public  ResponseEntity<Education> createEducation(Education edu);

    public void deleteEducation(Long id);

    public ResponseEntity<Education> updateEducation(@PathVariable Long id, @RequestBody Education toUpdateEducation);

}
