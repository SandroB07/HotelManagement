package com.intech.hotelmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Room
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "roomId")
    private Integer roomId;
    @Column(name = "room_capacity")
    private int maxCapacity;
    private RoomCategory category;
    private double price;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    @JsonIgnore
    private Hotel hotel;

    @OneToMany(cascade = ALL)
    private List<Availability> availabilities = new ArrayList<>();

    public Room(int maxCapacity, double price)
    {
        this.maxCapacity = maxCapacity;
        this.price = price;
        this.category = switch (maxCapacity)
                {
                    case 2 -> RoomCategory.STANDART;
                    case 4 -> RoomCategory.KING_SIZE;
                    case 6 -> RoomCategory.SUITE;
                    default -> null;
                };

    }

}
