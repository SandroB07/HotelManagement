package com.intech.hotelmanagement.mapper;

import com.intech.hotelmanagement.dto.BookingDto;
import com.intech.hotelmanagement.model.Booking;

import java.text.SimpleDateFormat;

public class BookingMapper
{

    public static BookingDto convertEntityToDto(Booking booking)
    {
        BookingDto dto = new BookingDto();

        dto.setBookingId(booking.getBookingId());
        dto.setName(booking.getName());
        dto.setHotelName(booking.getHotel().getName());
        dto.setRoomId(booking.getRoom().getRoomId());
        dto.setDateFrom(new SimpleDateFormat("dd/MM/yyyy").format(booking.getDateFrom()));
        dto.setDateTo(new SimpleDateFormat("dd/MM/yyyy").format(booking.getDateTo()));
        dto.setNbGuests(booking.getNbGuests());
        dto.setTotalPrice(booking.getTotalPrice());

        return dto;
    }

}
