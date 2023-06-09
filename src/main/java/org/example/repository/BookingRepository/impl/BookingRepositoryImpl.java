package org.example.repository.BookingRepository.impl;

import config.EntityManagerConfig;
import org.example.repository.BookingRepository.BookingRepository;
import org.example.model.Booking;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class BookingRepositoryImpl implements BookingRepository {
    private final EntityManager entityManager = EntityManagerConfig.getEntityManager();

    @Override
    public Booking save(Booking b) {
        if (b.getId()!=null){
            entityManager.getTransaction().begin();
            b.setBookingDate(b.getBookingDate());
            b.setStatus(b.getStatus());
            entityManager.getTransaction().commit();
            System.out.println("Booking updated!");
        }
        else {
            entityManager.getTransaction().begin();
            entityManager.persist(b);
            entityManager.getTransaction().commit();
            System.out.println("Booking added!");
        }
        return b;
    }

    @Override
    public Optional<Booking> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(Booking.class,id));
    }

    @Override
    public List<Booking> findAll() {
        String jpql = "SELECT b FROM Booking b";
        TypedQuery<Booking> query = entityManager.createQuery(jpql, Booking.class);
        return query.getResultList();
    }

    @Override
    public Booking delete(Booking b) {
        entityManager.getTransaction().begin();
        entityManager.remove(b);
        entityManager.getTransaction().commit();
        return b;
    }
}