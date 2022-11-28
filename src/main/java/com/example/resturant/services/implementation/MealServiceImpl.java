package com.example.resturant.services.implementation;

import com.example.resturant.dto.MealDto;
import com.example.resturant.entity.Meal;
import com.example.resturant.entity.enums.MealType;
import com.example.resturant.repository.MealRepository;
import com.example.resturant.services.MealService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class MealServiceImpl implements MealService {
    private MealRepository mealRepository;

//    @Override
//    public Meal createMealByRestaurant(Meal meal) {
//        return null;
//    }

    @Override
    public Meal createMealByRestaurant(Meal meal) {
        return null;
    }

    @Override
    public Meal createMealByRestaurant(MealDto mealDto) {

        Meal meal = new Meal();
        meal.setMealType(MealType.valueOf(mealDto.getMealType())); //Here since we are getting a String in my MealDto for thee mealType , i convert make sure that the Enum knows it is String
        meal.setDescription(mealDto.getDescription());
        meal.setAmount(mealDto.getAmount());
        meal.setName(mealDto.getName());
        meal.setTime(mealDto.getTime());
        meal.setImgUrl(mealDto.getImageUrl());

        return mealRepository.save(meal);
    }

    @Override
    public void removeMealByRestaurant() {

    }

    @Override
    public void updateMealByRestaurant() {

    }
//
//    @Override
//    public List<Meal> getMealsList() {
//
//        List<Meal> allMeals = mealRepository.findAll();
//        return allMeals;
//    }

//    @Override
//    public List<Meal> getMealsList() {
//        List<Meal> meals= mealRepository.findMealsByMealType();
//
//
////
////        Comparator<MealType>  = (Meal m1, Meal m2) ->m1.getMealType().compareTo(m2.getMealType());
////        meals.sort(compareByMealType);
//       return meals;

//    }

    @Override
    public List<Meal> getMealsList(String mealType) {
        List<Meal> meals = mealRepository.findMealsByMealType(mealType);
        return meals;
    }


}
