package com.intech.hotelmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelDto
{
    private Integer hotelId;
    private String name;
    private String city;
    private double rating;
    private List<RoomDto> rooms;
}
