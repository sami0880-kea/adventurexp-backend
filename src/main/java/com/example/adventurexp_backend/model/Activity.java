package com.example.adventurexp_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String image;
    private String description;
    private int minAge;
    private int price;

    public Activity(String name, String image, String description, int minAge, int price){
        this.name = name;
        this.image = image;
        this.description = description;
        this.minAge = minAge;
        this.price = price;
    }

}
