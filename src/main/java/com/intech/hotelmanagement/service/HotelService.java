package com.intech.hotelmanagement.service;

import com.intech.hotelmanagement.exception.HotelNotFoundException;
import com.intech.hotelmanagement.model.Hotel;
import com.intech.hotelmanagement.repository.HotelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HotelService
{

    private final HotelRepository repository;

    public List<Hotel> getAllHotels()
    {
        return repository.findAll();
    }

    public Hotel getHotelById(Integer hotelId)
    {
        return repository.findById(hotelId)
                .orElseThrow(() -> new HotelNotFoundException(String.format("Hotel %s not found !!!", hotelId)));
    }

    public Hotel addHotel(Hotel hotel)
    {
        return repository.save(hotel);
    }

}
