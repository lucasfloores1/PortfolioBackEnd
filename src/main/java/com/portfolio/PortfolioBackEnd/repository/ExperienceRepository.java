package com.portfolio.PortfolioBackEnd.repository;

import com.portfolio.PortfolioBackEnd.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {

}
