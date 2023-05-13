package com.portfolio.PortfolioBackEnd.controller;

import com.portfolio.PortfolioBackEnd.model.Info;
import com.portfolio.PortfolioBackEnd.service.InfoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin( origins = "https://portfoliofrontend-f9741.web.app/" )
public class InfoController {
    
    @Autowired
    private InfoService infoServ;
    
    
    @GetMapping("/info/load/{id}")
    @ResponseBody
    public Info loadInfo(@PathVariable Long id) {
        return infoServ.loadInfo(id);
    }
    
    @PostMapping("/info/create")
    public ResponseEntity<Info> createInfo(@RequestBody Info info) {
        ResponseEntity<Info> response;

        Info createdInfo = infoServ.createInfo(info).getBody();

        if (createdInfo != null) {
            response = ResponseEntity.ok(createdInfo);
        } else {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return response;
    }    
    
    @DeleteMapping("/info/delete/{id}")
    public void deleteInfo(@PathVariable Long id) {
        infoServ.deleteInfo(id);
    }
    
    @PutMapping("/info/update/{id}")
    public ResponseEntity<Info> updateInfo(@PathVariable Long id, @RequestBody Info toUpdateInfo) {
        return infoServ.updateInfo(id, toUpdateInfo);
    }
    
}
