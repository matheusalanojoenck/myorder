package com.example.myorder.repositories;


import com.example.myorder.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u " +
            "WHERE u.email = :userEmail")
    public User findByEmail(@Param("userEmail") String email);
}
