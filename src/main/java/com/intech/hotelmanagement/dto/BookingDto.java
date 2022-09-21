package com.intech.hotelmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * A DTO for the {@link com.intech.hotelmanagement.model.Booking} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto implements Serializable
{
    private Integer bookingId;
    private String name;
    private String hotelName;
    private Integer roomId;
    private String dateFrom;
    private String dateTo;
    private Integer nbGuests;
    private double totalPrice;
}