package com.intech.hotelmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto
{
    private Integer roomId;
    private int maxCapacity;
    private String category;
    private double price;
    private Integer hotelId;
    private String availability;
}
