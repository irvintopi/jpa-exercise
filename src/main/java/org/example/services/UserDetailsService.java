package org.example.services;

import org.example.model.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserDetailsService {
    public UserDetails save(UserDetails u);
    public Optional<UserDetails> findById(Integer id);
    public List<UserDetails> findAll();
    public UserDetails delete(UserDetails u);
}