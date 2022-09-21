package com.intech.hotelmanagement.exception;

public class HotelNotFoundException extends RuntimeException
{
    public HotelNotFoundException(String message)
    {
        super(message);
    }
}
