package com.portfolio.PortfolioBackEnd.service;

import com.portfolio.PortfolioBackEnd.model.Info;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface IInfoService {
    
    public Info loadInfo(Long id);

    public  ResponseEntity<Info> createInfo(Info info);

    public void deleteInfo(Long id);

    public ResponseEntity<Info> updateInfo(@PathVariable Long id, @RequestBody Info toUpdateInfo);

    
}
