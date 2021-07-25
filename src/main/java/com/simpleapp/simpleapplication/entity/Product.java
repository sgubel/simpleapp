package com.simpleapp.simpleapplication.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected int id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "price")
    private Double price;

    @Column(name = "country")
    private String country;

}
