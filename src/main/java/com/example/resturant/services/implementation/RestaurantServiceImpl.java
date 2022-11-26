package com.example.resturant.services.implementation;

import com.example.resturant.dto.RestaurantDto;
import com.example.resturant.dto.LoginDto;
import com.example.resturant.entity.Restaurant;
import com.example.resturant.exceptions.RestaurantException;
import com.example.resturant.repository.RestaurantRepository;
import com.example.resturant.services.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepo;



    @Override
    public Restaurant login( LoginDto loginDto) { //Here we are trying to find out if the email and password are correct and if it isn't we thjrow an exception but if it is correct we return the get() method in line 30.
        Optional<Restaurant> findByEmailAndPassword = restaurantRepo.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());
        System.out.println("I got here 1");
        if (findByEmailAndPassword.get() != null) {
            System.out.println(findByEmailAndPassword.get());
            System.out.println("I got here 2");
            return findByEmailAndPassword.get();
        }
        System.out.println("I got here 3");
        throw new RestaurantException("Email or password is incorrect");

    }

    @Override
    public Restaurant signUp(RestaurantDto restaurantDto) {
        Restaurant restaurant = new Restaurant();

//        Optional<Restaurant> foundByEmail = restaurantRepo.findByEmail(restaurantDto.getEmail());
//        if (foundByEmail.isPresent()) {
//            throw new RestaurantException("User already exists with the email " + restaurantDto.getEmail());
//        } else {
//
//            restaurant.setOwnersName(restaurantDto.getOwnersName());
//            restaurant.setEmail(restaurantDto.getEmail());
//            restaurant.setRestaurantAddress(restaurantDto.getRestaurantAddress());
//            restaurant.setRestaurantName(restaurantDto.getRestaurantName());
//            restaurant.setCacFileName(restaurantDto.getCac());
//            restaurant.setPhoneNumber(restaurantDto.getPhoneNumber());
//            restaurant.setPassword(restaurantDto.getPassword());

            restaurantRepo.save(restaurant);

//        }

        return restaurant;
    }

    @Override
    public void updateProfile() {

    }



}
