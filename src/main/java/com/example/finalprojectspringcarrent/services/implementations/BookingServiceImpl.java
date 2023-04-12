package com.example.finalprojectspringcarrent.services.implementations;

import com.example.finalprojectspringcarrent.exceptions.BookingNotFoundException;
import com.example.finalprojectspringcarrent.models.Booking;
import com.example.finalprojectspringcarrent.models.Branch;
import com.example.finalprojectspringcarrent.services.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tiina Raudla
 * @Date
 */
@Service
public class BookingServiceImpl implements BookingService {
    @Override
    public void addBooking(Booking booking) {

    }
    @Override
    public Booking findBookingByDateOfBooking(Long date) throws BookingNotFoundException {
        return null;
    }

    @Override
    public Booking findBookingByClientName(String name) throws BookingNotFoundException {
        return null;
    }

    @Override
    public List<Booking> findAllBookings() {
        return null;
    }

    @Override
    public List<Booking> findAllBookingsByBranches(Branch branch) {
        return null;
    }

    @Override
    public void updateBooking(Booking booking) throws BookingNotFoundException {

    }

    @Override
    public void deleteBookingByDateOfBooking(Long date) throws BookingNotFoundException {

    }

    @Override
    public void restoreBookingByDateOfBooking(Long date) throws BookingNotFoundException {

    }
}
