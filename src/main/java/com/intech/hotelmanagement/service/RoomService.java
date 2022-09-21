package com.intech.hotelmanagement.service;

import com.intech.hotelmanagement.contract.RoomContract;
import com.intech.hotelmanagement.exception.RoomNotExistsException;
import com.intech.hotelmanagement.model.Hotel;
import com.intech.hotelmanagement.model.Room;
import com.intech.hotelmanagement.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomService
{

    private final RoomRepository repository;
    private final HotelService hotelService;

    public List<Room> getAllRooms()
    {
        return repository.findAll();
    }

    public List<Room> getRoomsByHotel(Integer hotelId)
    {
        Hotel hotel = hotelService.getHotelById(hotelId);

        return hotel.getRooms();
    }

    public Room getRoomById(Integer roomId)
    {
        return repository.findById(roomId)
                .orElseThrow(() -> new RoomNotExistsException(String.format("Room %s doesn't exist !!!", roomId)));
    }

    public Room addRoomForHotel(RoomContract roomContract)
    {
        Hotel hotel = hotelService.getHotelById(roomContract.getHotelId());
        Room room = new Room(roomContract.getMaxCapacity(), roomContract.getPrice());
        room.setHotel(hotel);
        hotel.getRooms().add(room);

        hotelService.addHotel(hotel);

        return room;
    }
}


