package com.portfolio.PortfolioBackEnd.service;

import com.portfolio.PortfolioBackEnd.model.Info;
import com.portfolio.PortfolioBackEnd.repository.InfoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class InfoService implements IInfoService{
    
    @Autowired
    public InfoRepository infoRepo;

    @Override
    public Info loadInfo(Long id) {
       return infoRepo.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<Info> createInfo(Info inf) {
        Info info = infoRepo.save(inf);
        return ResponseEntity.ok(inf);
    }

    @Override
    public void deleteInfo(Long id) {
        infoRepo.deleteById(id);        
    }

    @Override
    public ResponseEntity<Info> updateInfo(@PathVariable Long id,@RequestBody Info toUpdateInfo) {
        Info info = infoRepo.findById(id).orElse(null);

        info.setName            (toUpdateInfo.getName());
        info.setDescription     (toUpdateInfo.getDescription());
        info.setBannerurl       (toUpdateInfo.getBannerurl());
        info.setPfpurl          (toUpdateInfo.getPfpurl());

        Info updatedInfo = infoRepo.save(info);

        return ResponseEntity.ok(updatedInfo);
    }
    
}
