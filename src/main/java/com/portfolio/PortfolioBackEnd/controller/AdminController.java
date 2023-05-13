package com.portfolio.PortfolioBackEnd.controller;

import com.portfolio.PortfolioBackEnd.model.Admin;
import com.portfolio.PortfolioBackEnd.service.AdminService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin( origins = "https://portfoliofrontend-f9741.web.app/" )
public class AdminController {
    
    @Autowired 
    private AdminService admServ;
    
    @GetMapping("/admin/load/{id}")
    @ResponseBody
    public Admin loadAdmin(@PathVariable Long id) {
        return admServ.loadAdmin(id);
    }
    
    @PostMapping ( "/admin/create" )
    public void createAdmin(@RequestBody Admin admin){
        admServ.createAdmin(admin);
    }
    
    
}
