package com.example.resturant.services.implementation;

import com.example.resturant.dto.MealDto;
import com.example.resturant.entity.Meal;
import com.example.resturant.entity.enums.MealType;
import com.example.resturant.repository.MealRepository;
import com.example.resturant.services.MealService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MealServiceImpl implements MealService {
    private MealRepository mealRepository;

//    @Override
//    public Meal createMealByRestaurant(Meal meal) {
//        return null;
//    }

    @Override
    public Meal createMealByRestaurant(MealDto mealDto) {
        Meal meal = new Meal();
        meal.setMealType(MealType.valueOf(mealDto.getMealType())); //Here since we are getting a String in my MealDto for thee mealType , i convert make sure that the Enum knows it is String
        meal.setDescription(mealDto.getDescription());
        meal.setAmount(mealDto.getAmount());
        meal.setName(mealDto.getName());
        meal.setTime(mealDto.getTime());
        meal.setImgUrl(mealDto.getImgUrl());

        return mealRepository.save(meal);
    }

    @Override
    public void removeMealByRestaurant() {

    }

    @Override
    public void updateMealByRestaurant() {

    }
}
