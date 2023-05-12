package com.portfolio.PortfolioBackEnd.service;


import com.portfolio.PortfolioBackEnd.model.Admin;
import com.portfolio.PortfolioBackEnd.repository.AdminRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements IAdminService{

    @Autowired
    public AdminRepository admRepo;

    @Override
    public Admin loadAdmin(Long id) {
        return admRepo.findById(id).orElse(null);
        
    }

    @Override
    public void createAdmin(Admin admin) {
        admRepo.save(admin);
    }


    
    


    

}
