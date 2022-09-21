package com.intech.hotelmanagement.contract;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class RoomContract
{
    private Integer hotelId;
    private int maxCapacity;
    private double price;
}
