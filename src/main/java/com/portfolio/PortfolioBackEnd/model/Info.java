package com.portfolio.PortfolioBackEnd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Info {
    
    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO )
    private Long id;
    
    @Column ( name = "name" , length = 200 , nullable = false )
    private String name;
    
    @Column ( name = "description" , length = 200 , nullable = false )
    private String description;
    
    @Column ( name = "bannerurl" , length = 200 , nullable = false )
    private String bannerurl;
    
    @Column ( name = "pfpurl" , length = 200 , nullable = false )
    private String pfpurl;
    
    public Info (){
        
    }

    public Info(Long id, String name, String description, String bannerurl, String pfpurl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.bannerurl = bannerurl;
        this.pfpurl = pfpurl;
    }
    
    
    
            
            
    
}
