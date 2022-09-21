package com.intech.hotelmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hotelId")
    private Integer hotelId;
    private String name;
    private String city;
    private double rating;

    @OneToMany(cascade = ALL)
    private List<Room> rooms = new ArrayList<>();

    public Hotel(String name, String city, double rating)
    {
        this.name = name;
        this.city = city;
        this.rating = rating;
    }

}
