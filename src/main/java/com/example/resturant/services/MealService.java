package com.example.resturant.services;


import com.example.resturant.dto.MealDto;
import com.example.resturant.entity.Attach;
import com.example.resturant.entity.Meal;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MealService {

//    Meal createMealByRestaurant(Meal meal);

    Meal createMealByRestaurant(Meal meal);

    Meal createMealByRestaurant(MealDto mealDto);

    void removeMealByRestaurant();

    void updateMealByRestaurant();

//    List<Meal> getMealsList();

    List<Meal> getMealsList(String mealType);


}
