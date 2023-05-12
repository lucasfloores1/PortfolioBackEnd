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
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "imgurl", length = 200, nullable = false)
    private String imgurl;
    @Column(name = "institute", length = 200, nullable = false)
    private String institute;
    @Column(name = "title", length = 200, nullable = false)
    private String title;
    @Column(name = "time", length = 200, nullable = false)
    private String time;

    public Education() {

    }

    public Education(Long id, String imgurl, String institute, String title, String time) {
        this.id = id;
        this.imgurl = imgurl;
        this.institute = institute;
        this.title = title;
        this.time = time;
    }

}
