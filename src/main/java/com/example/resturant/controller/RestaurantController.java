package com.example.resturant.controller;

import com.example.resturant.dto.LoginDto;
import com.example.resturant.dto.RestaurantDto;
import com.example.resturant.entity.Restaurant;
import com.example.resturant.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    //Here we handle the signup API
    @PostMapping("/signup")
    public Restaurant signUp(@RequestBody RestaurantDto restaurantDto){
        Restaurant restaurant = restaurantService.signUp(restaurantDto);
        return restaurant;
    }

    //Here we handle the login API
    @GetMapping("/login")
    public Restaurant login(@RequestBody LoginDto loginDto) {
        Restaurant restaurant = restaurantService.login(loginDto);
        return restaurant;
    }

}
