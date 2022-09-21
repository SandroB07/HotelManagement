package com.intech.hotelmanagement.repository;

import com.intech.hotelmanagement.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer>
{
}