package com.intech.hotelmanagement.controller;

import com.intech.hotelmanagement.contract.BookingContract;
import com.intech.hotelmanagement.dto.BookingDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

@RestController
@RequestMapping("api/book")
public class BookingController
{

    @RequestMapping(value = "/hotel/{hotelId}/room/{roomId}", method = {POST, PUT, DELETE})
    public ResponseEntity<BookingDto> addBooking(
            @PathVariable("hotelId") Integer hotelId,
            @PathVariable("roomId") Integer roomId,
            @RequestBody BookingContract bookingContract
    )
    {

    }

}
