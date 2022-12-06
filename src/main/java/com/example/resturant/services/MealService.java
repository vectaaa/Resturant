package com.example.resturant.services;


import com.example.resturant.dto.MealDto;
import com.example.resturant.entity.Meal;

import java.util.List;

public interface MealService {

//    Meal createMealByRestaurant(Meal meal);

    Meal createMealByRestaurant(Meal meal);

    Meal createMealByRestaurant(MealDto mealDto);

    void removeMealByRestaurant();

    void updateMealByRestaurant();


    List<Meal> getMealByRestaurantId(Long id);

    List<Meal> getMealsList();

    List<Meal> getMealsListByMealType();




}
