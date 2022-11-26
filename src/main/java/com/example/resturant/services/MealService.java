package com.example.resturant.services;


import com.example.resturant.dto.MealDto;
import com.example.resturant.entity.Meal;

public interface MealService {

//    Meal createMealByRestaurant(Meal meal);

    Meal createMealByRestaurant(MealDto mealDto);

    void removeMealByRestaurant();

    void updateMealByRestaurant();

}
