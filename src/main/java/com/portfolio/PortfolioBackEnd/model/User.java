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
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username", length = 200, nullable = false)
    private String username;
    
    @Column(name = "password", length = 200, nullable = false)
    private String password;
    
    @Column(name = "title", length = 200, nullable = false)
    private String title;
    
    @Column ( name = "name" , length = 200 , nullable = false )
    private String name;
    
    @Column ( name = "aboutme" , length = 200 , nullable = false )
    private String aboutme;
    
    @Column ( name = "description" , length = 200 , nullable = false )
    private String description;
    
    @Column ( name = "bannerurl" , length = 200 , nullable = false )
    private String bannerurl;
    
    @Column ( name = "pfpurl" , length = 200 , nullable = false )
    private String pfpurl;

    public User() {
    }

    public User(Long id, String username, String password, String title, String name, String aboutme, String description, String bannerurl, String pfpurl) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.title = title;
        this.name = name;
        this.aboutme = aboutme;
        this.bannerurl = bannerurl;
        this.pfpurl = pfpurl;
    }
    
}