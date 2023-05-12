package com.portfolio.PortfolioBackEnd.repository;

import com.portfolio.PortfolioBackEnd.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
    
}
