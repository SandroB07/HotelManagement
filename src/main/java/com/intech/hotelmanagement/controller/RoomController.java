package com.intech.hotelmanagement.controller;

import com.intech.hotelmanagement.contract.RoomContract;
import com.intech.hotelmanagement.dto.RoomDto;
import com.intech.hotelmanagement.mapper.RoomMapper;
import com.intech.hotelmanagement.model.Room;
import com.intech.hotelmanagement.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rooms")
@AllArgsConstructor
public class RoomController
{
    private final RoomService roomService;

    @GetMapping
    public ResponseEntity<List<RoomDto>> fetchAllRooms()
    {
        return ResponseEntity.ok(
                roomService.getAllRooms().stream()
                        .map(RoomMapper::convertEntityToDto)
                        .toList()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDto> fetchRoomById(@PathVariable("id") Integer roomId)
    {
        return ResponseEntity.ok(RoomMapper.convertEntityToDto(roomService.getRoomById(roomId)));
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<RoomDto>> fetchRoomsByHotelId(@PathVariable("hotelId") Integer hotelId)
    {
        return ResponseEntity.ok(
                roomService.getRoomsByHotel(hotelId).stream()
                        .map(RoomMapper::convertEntityToDto)
                        .toList()
        );
    }

    @PutMapping
    public ResponseEntity<Room> addRoomForHotel(@RequestBody RoomContract roomContract)
    {
        return ResponseEntity.ok(roomService.addRoomForHotel(roomContract));
    }

}
