package com.example.resturant.services;

import com.example.resturant.dto.RestaurantDto;
import com.example.resturant.dto.LoginDto;
import com.example.resturant.entity.Restaurant;

public interface RestaurantService {
    Restaurant signUp(RestaurantDto restaurantDto);

    Restaurant login(LoginDto loginDto);

    void updateProfile();
}
