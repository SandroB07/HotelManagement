package com.intech.hotelmanagement.repository;

import com.intech.hotelmanagement.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Integer>
{
    Optional<Hotel> findByCity(String city);
}