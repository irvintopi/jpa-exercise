package org.example.services;

import org.example.model.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    public Booking save(Booking b);
    public Optional<Booking> findById(Integer id);
    public List<Booking> findAll();
    public Booking delete(Booking u);
}