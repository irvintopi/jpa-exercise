package org.example.services.Impl;
import org.example.repository.FlightRepository.FlightRepository;
import org.example.model.Flight;
import org.example.model.User;
import org.example.repository.FlightRepository.impl.FlightRepositoryImpl;
import org.example.services.FlightService;

import java.util.List;
import java.util.Optional;
public class FlightServiceImpl implements FlightService {
    FlightRepository flights = new FlightRepositoryImpl();
    public Flight save(Flight f){
        return flights.save(f);
    }
    public Optional<Flight> findById(Integer id){
        return flights.findById(id);
    }
    public List<Flight> findAll(){
        return flights.findAll();
    }
    public Flight delete(Flight f){
        return flights.delete(f);
    }
    public List<User> allUsers(int x){return flights.allUsers(x);}
}