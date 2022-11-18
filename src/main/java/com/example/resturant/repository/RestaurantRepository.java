package com.example.resturant.repository;

import com.example.resturant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
    Optional<Restaurant> findByEmail(String email);// checks the restaurant repo to know if the email user is registering with already exists

    Optional<Restaurant> findByEmailAndPassword(String email, String password);// checks the table or db for an existence of the same Email and password and makes sure that they both match for validation.

}
