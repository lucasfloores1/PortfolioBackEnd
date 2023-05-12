package com.portfolio.PortfolioBackEnd.repository;

import com.portfolio.PortfolioBackEnd.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository <Project , Long> {
       
    
}
