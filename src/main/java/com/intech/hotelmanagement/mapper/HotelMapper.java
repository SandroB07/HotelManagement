package com.intech.hotelmanagement.mapper;

import com.intech.hotelmanagement.dto.HotelDto;
import com.intech.hotelmanagement.dto.RoomDto;
import com.intech.hotelmanagement.model.Hotel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class HotelMapper
{

    public static HotelDto convertEntityToDto(Hotel hotel)
    {
        HotelDto dto = new HotelDto();

        dto.setHotelId(hotel.getHotelId());
        dto.setName(hotel.getName());
        dto.setCity(hotel.getCity());
        dto.setRating(hotel.getRating());

        List<RoomDto> roomDtos = hotel.getRooms().stream()
                .map(RoomMapper::convertEntityToDto)
                .toList();

        dto.setRooms(roomDtos);

        return dto;
    }
}
