package com.intech.hotelmanagement.config;

import com.intech.hotelmanagement.model.Availability;
import com.intech.hotelmanagement.model.Hotel;
import com.intech.hotelmanagement.model.Room;
import com.intech.hotelmanagement.repository.HotelRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;


@Component
@AllArgsConstructor
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent>
{

    private final HotelRepository hotelRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {

        for(int i = 0; i < 3; i++)
        {
            Hotel hotel = switch (i)
                    {
                        case 0 -> new Hotel("Sheraton Palace", "Batumi", 4.0);
                        case 1 -> new Hotel("Ibis", "Brussels", 2.5);
                        case 2 -> new Hotel("Paris", "Paris", 5.0);
                        default -> null;
                    };
            Room std_1 = new Room(2, 60.0);
            Room std_2 = new Room(2,  60.0);
            Room std_3 = new Room(2,  60.0);
            Room std_4 = new Room(2,  60.0);
            Room std_5 = new Room(2,  60.0);
            Room std_6 = new Room(2,  60.0);
            Room king_1 = new Room(4, 100.0);
            Room king_2 = new Room(4, 100.0);
            Room king_3 = new Room(4, 100.0);
            Room king_4 = new Room(4, 100.0);
            Room suite = new Room(6, 200.0);

            List<Room> roomList = Arrays.asList(
                std_1, std_2, std_3, std_4, std_5, std_6,
                king_1, king_2, king_3, king_4,
                suite
            );

            for (Room room : roomList)
            {
                Availability availability = new Availability();
                room.setHotel(hotel);
                availability.setRoom(room);
                try
                {
                    availability.setAvalaibleFrom(new SimpleDateFormat("dd/MM/yyyy")
                            .parse("22/09/2022"));
                    availability.setAvalaibleTo(new SimpleDateFormat("dd/MM/yyyy")
                            .parse("22/09/2023"));
                } catch (ParseException e)
                {
                    throw new RuntimeException(e);
                }
                room.getAvailabilities().add(availability);
            }
            hotel.setRooms(roomList);
            hotelRepository.save(hotel);
        }



    }
}
