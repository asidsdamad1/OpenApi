package com.example.apisync.repository;

import com.example.apisync.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select e from User e where e.username=?1")
    User getByUsername(String username);

    Optional<User> findByUsername(String username);

    Optional<User> findById(Long id);

}
