package com.intech.hotelmanagement.repository;

import com.intech.hotelmanagement.model.Hotel;
import com.intech.hotelmanagement.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer>
{
}

