package com.portfolio.PortfolioBackEnd.service;
import com.portfolio.PortfolioBackEnd.model.Admin;
import java.util.List;


public interface IAdminService {
    
    public Admin loadAdmin(Long id);
    
    public void createAdmin(Admin admin);
    
}
