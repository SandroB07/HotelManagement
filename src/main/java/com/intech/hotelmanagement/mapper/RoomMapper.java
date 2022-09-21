package com.intech.hotelmanagement.mapper;

import com.intech.hotelmanagement.dto.RoomDto;
import com.intech.hotelmanagement.model.Availability;
import com.intech.hotelmanagement.model.Room;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Component
public class RoomMapper
{
    public static RoomDto convertEntityToDto(Room room)
    {
        // Date format
        String pattern = "dd/MM/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);

        // =========================
        RoomDto dto = new RoomDto();
        dto.setRoomId(room.getRoomId());
        String category = switch (room.getCategory())
                {
                    case STANDART -> "Standart";
                    case KING_SIZE -> "King size";
                    case SUITE -> "Suite";
                };
        dto.setCategory(category);
        dto.setPrice(room.getPrice());
        dto.setHotelId(room.getHotel().getHotelId());
        dto.setMaxCapacity(room.getMaxCapacity());

        StringBuilder availDto = new StringBuilder();

        for (Availability availability : room.getAvailabilities())
        {
            if (room.getAvailabilities().size() == 1)
            {
                availDto.append(df.format(availability.getAvalaibleFrom()))
                        .append(" - ")
                        .append(df.format(availability.getAvalaibleTo()));
            } else
            {
                availDto.append(df.format(availability.getAvalaibleFrom()))
                        .append(" - ")
                        .append(df.format(availability.getAvalaibleTo()))
                        .append(", ");
            }
        }

        String availability = availDto.toString();

        if (room.getAvailabilities().size() > 1)
        {
            availability = availability.substring(0, availability.length() - 1);
        }

        dto.setAvailability(availability);

        return dto;
    }
}
