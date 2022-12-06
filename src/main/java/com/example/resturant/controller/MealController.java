package com.example.resturant.controller;


import com.example.resturant.dto.MealDto;
import com.example.resturant.entity.Meal;
import com.example.resturant.entity.enums.MealType;
import com.example.resturant.repository.MealRepository;
import com.example.resturant.services.MealService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/meals")
public class MealController {

    private final Logger LOGGER = LoggerFactory.getLogger(MealDto.class);
    @Autowired
    private  MealService mealService;

    @Autowired
    private MealRepository mealRepository;


    @PostMapping("/createMeals")
    public ResponseEntity<Meal> createMeals(@Valid @RequestBody MealDto mealDto) {
        System.out.println("It is showing");
        LOGGER.info("This name string is" + mealDto.getDescription());

        return new ResponseEntity<>(mealService.createMealByRestaurant(mealDto), HttpStatus.OK);
    }

// this is the right one, i believe and it was just an sql query.
    @PostMapping
    public ResponseEntity<List<Meal>> getAllMealByMealType(){
       return new ResponseEntity<>(mealRepository.findByOrderByMealType(), HttpStatus.OK);
    }
    @GetMapping("/Mealsbyrestaurant/{id}")
    public ResponseEntity<List<Meal>> getMealsByRestaurantId(@PathVariable("id") Long id ){
        return new ResponseEntity<>(mealService.getMealByRestaurantId(id), HttpStatus.OK);
    }

}
