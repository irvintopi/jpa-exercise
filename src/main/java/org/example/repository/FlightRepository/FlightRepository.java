package org.example.repository.FlightRepository;

import org.example.model.Flight;
import org.example.model.User;

import java.util.List;
import java.util.Optional;
public interface FlightRepository {
    public Flight save(Flight f);
    public Optional<Flight> findById(Integer id);
    public List<Flight> findAll();
    public Flight delete(Flight f);
    public List<User> allUsers(int x);
}