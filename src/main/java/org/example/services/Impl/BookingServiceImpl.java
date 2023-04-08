package org.example.services.Impl;

import org.example.repository.BookingRepository.BookingRepository;
import org.example.repository.BookingRepository.impl.*;
import org.example.model.Booking;
import org.example.services.BookingService;

import java.util.List;
import java.util.Optional;

public class BookingServiceImpl implements BookingService {
    BookingRepository bookings = new BookingRepositoryImpl();
    public Booking save(Booking b){
        return bookings.save(b);
    }
    public Optional<Booking> findById(Integer id){
        return bookings.findById(id);
    }
    public List<Booking> findAll(){
        return bookings.findAll();
    }
    public Booking delete(Booking u){
        return bookings.delete(u);
    }
}