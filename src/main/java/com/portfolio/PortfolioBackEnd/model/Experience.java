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
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "imgurl", length = 200, nullable = false)
    private String imgurl;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Column(name = "company", length = 200, nullable = false)
    private String company;

    @Column(name = "time", length = 200, nullable = false)
    private String time;

    public Experience(Long id, String imgurl, String name, String company, String time) {
        this.id = id;
        this.imgurl = imgurl;
        this.name = name;
        this.company = company;
        this.time = time;
    }

    public Experience() {
    }

}
