package org.example.repository.UserDetailsRepository.Impl;

import config.EntityManagerConfig;
import org.example.repository.UserDetailsRepository.UserDetailsRepository;
import org.example.model.User;
import org.example.model.UserDetails;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class UserDetailsRepositoryImpl implements UserDetailsRepository {
    private EntityManager entityManager = EntityManagerConfig.getEntityManager();
    @Override
    public UserDetails save(UserDetails u) {
        entityManager.getTransaction().begin();
        entityManager.persist(u);
        entityManager.getTransaction().commit();
        System.out.println("User Details successfully added");
        return u;
    }

    @Override
    public Optional<UserDetails> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(UserDetails.class,id));
    }

    @Override
    public List<UserDetails> findAll() {
        TypedQuery<UserDetails> result = entityManager.createQuery("SELECT ud from UserDetails ud", UserDetails.class);
        return result.getResultList();
    }

    @Override
    public UserDetails delete(UserDetails u) {
        entityManager.getTransaction().begin();
        entityManager.remove(u);
        entityManager.getTransaction().commit();
        return u;
    }
}