package com.portfolio.PortfolioBackEnd.repository;

import com.portfolio.PortfolioBackEnd.model.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepository extends JpaRepository <Info, Long>{
    
}
