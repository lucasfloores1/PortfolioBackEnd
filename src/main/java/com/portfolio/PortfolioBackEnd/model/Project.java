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
public class Project {
    
    @Id
    @GeneratedValue ( strategy= GenerationType.AUTO )
    private Long id;
    
    @Column ( name = "name", length = 200 , nullable = false )
    private String name;
    
    @Column ( name = "description", length = 200 , nullable = false )
    private String description;
    
    @Column ( name = "link", length = 200 , nullable = false )
    private String link;
    
    public Project (){
        
    }

    public Project(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    
    
    
}
