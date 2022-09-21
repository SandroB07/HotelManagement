package com.intech.hotelmanagement.exception;

public class RoomNotExistsException extends RuntimeException
{
    public RoomNotExistsException(String message)
    {
        super(message);
    }
}
