package com.intech.hotelmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Booking
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookingId;

    private String name;

    @OneToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "hotelId")
    private Hotel hotel;
    @OneToOne
    @JoinColumn(name = "room_id", referencedColumnName = "roomId")
    private Room room;
    @Column(nullable = false)
    private Date dateFrom;
    @Column(nullable = false)
    private Date dateTo;
    private Integer nbGuests;

    private double totalPrice;

    //Ctor


    //Methods
    private double calculateTotalPrice()
    {
        LocalDateTime arrival = dateFrom.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        LocalDateTime departure = dateTo.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        double nbNights = (double) Duration.between(departure, arrival).toDays();

        return room.getPrice() * nbGuests * nbNights;
    }

}
