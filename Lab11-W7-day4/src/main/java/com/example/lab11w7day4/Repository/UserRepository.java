package com.example.lab11w7day4.Repository;

import com.example.lab11w7day4.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserById(Integer id);

    @Query("select u from User u where u.email=?1")
    User getUserByEmail(String email);

    User findUserByUsername(String username);

    @Query("select u from User u where u.registration_date=?1")
    List<User> findAllByRegistration_date(LocalDate findAllByRegistration_date);


}