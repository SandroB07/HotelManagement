package com.intech.hotelmanagement.contract;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookingContract
{
    private String name;
    private int nbGuests;
    private String arrival;
    private String departure;
//    private Integer hotelId;
//    private Integer roomId;
}
