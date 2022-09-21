/*
package com.intech.hotelmanagement.config;

import com.intech.hotelmanagement.model.Hotel;
import com.intech.hotelmanagement.model.Room;
import com.intech.hotelmanagement.model.RoomCategory;
import com.intech.hotelmanagement.repository.BookingRepository;
import com.intech.hotelmanagement.repository.HotelRepository;
import com.intech.hotelmanagement.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

import static com.intech.hotelmanagement.model.RoomCategory.*;

@Configuration
@Slf4j
public class LoaderConfig
{

    @Bean
    public CommandLineRunner initDatabase(HotelRepository hotelRepository, RoomRepository roomRepository)
    {
        return args -> {
            Hotel hotel1 = new Hotel("Sheraton Palace", "Batumi", 4.0);
            Hotel hotel2 = new Hotel("Ibis", "Brussels", 2.5);
            Hotel hotel3 = new Hotel("Paris", "Paris", 5.0);

            Room std_1 = new Room(2, STANDART, 60.0);
            Room std_2 = new Room(2, STANDART, 60.0);
            Room std_3 = new Room(2, STANDART, 60.0);
            Room std_4 = new Room(2, STANDART, 60.0);
            Room std_5 = new Room(2, STANDART, 60.0);
            Room std_6 = new Room(2, STANDART, 60.0);
            Room king_1 = new Room(4, KING_SIZE, 100.0);
            Room king_2 = new Room(4, KING_SIZE, 100.0);
            Room king_3 = new Room(4, KING_SIZE, 100.0);
            Room king_4 = new Room(4, KING_SIZE, 100.0);
            Room suite = new Room(6, SUITE, 200.0);

            List<Room> roomList = new ArrayList<>();
            roomList.add(std_1);
            roomList.add(std_2);
            roomList.add(std_3);
            roomList.add(std_4);
            roomList.add(std_5);
            roomList.add(std_6);
            roomList.add(king_1);
            roomList.add(king_2);
            roomList.add(king_3);
            roomList.add(king_4);
            roomList.add(suite);

            hotel1.setRooms(roomList);
            hotel2.setRooms(roomList);
            hotel3.setRooms(roomList);

            hotelRepository.save(hotel1);
            hotelRepository.save(hotel2);
            hotelRepository.save(hotel3);
        };
    }

}
*/
