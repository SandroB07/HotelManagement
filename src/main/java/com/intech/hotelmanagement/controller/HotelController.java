package com.intech.hotelmanagement.controller;


import com.intech.hotelmanagement.dto.HotelDto;
import com.intech.hotelmanagement.mapper.HotelMapper;
import com.intech.hotelmanagement.model.Hotel;
import com.intech.hotelmanagement.service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/hotels")
public class HotelController
{

    private final HotelService hotelService;

    @GetMapping
    public ResponseEntity<List<HotelDto>> fetchAllHotels()
    {
        return ResponseEntity.ok(
                hotelService.getAllHotels()
                    .stream()
                    .map(HotelMapper::convertEntityToDto)
                    .toList()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelDto> fetchHotelById(@PathVariable("id") Integer hotelId)
    {
        HotelDto dto = HotelMapper.convertEntityToDto(hotelService.getHotelById(hotelId));
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public Hotel addHotel(@RequestBody Hotel hotel)
    {
        return hotelService.addHotel(hotel);
    }

}
