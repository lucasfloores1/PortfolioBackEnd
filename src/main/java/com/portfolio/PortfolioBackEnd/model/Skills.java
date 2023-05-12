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
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Column(name = "color", length = 200, nullable = false)
    private String color;

    @Column(name = "value", nullable = false)
    private int value;

    public Skills() {
    }

    public Skills(Long id, String name, String color, int value) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.value = value;
    }

}
