package org.example.repository.BookingRepository;
import org.example.model.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingRepository {
    public Booking save(Booking b);
    public Optional<Booking> findById(Integer id);
    public List<Booking> findAll();
    public Booking delete(Booking b);
}