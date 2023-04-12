package com.example.finalprojectspringcarrent.exceptions;

/**
 * @author Tiina Raudla
 * @Date
 */
public class BookingNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;

    public BookingNotFoundException(Long date) {
        super(String.format("Booking not found for date: %d", date));
    }
    public BookingNotFoundException (String clientName) {
        super(String.format("Booking not found for clientName: %s", clientName));
    }

}
