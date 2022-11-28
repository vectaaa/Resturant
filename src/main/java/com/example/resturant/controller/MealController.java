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
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

@RestController
@AllArgsConstructor
@CrossOrigin
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

        return new ResponseEntity<>(mealService.createMealByRestaurant(mealDto), HttpStatus.CREATED);
    }

//    @GetMapping("/getMeals")
//    public  ResponseEntity<List<Meal>> getAllMeals(){
//
//        List<Meal> result = mealService.getMealsList();
//
//        return new ResponseEntity<>(result, HttpStatus.FOUND);
//
//    }


    @GetMapping("/{getMealsByType}")
    public ResponseEntity<List<Meal>> getMealByMealType(@PathVariable("getMealsByType") MealType mealType){
        String milType = mealType.name();
        List<Meal> result = mealService.getMealsList(milType);
//
       return new ResponseEntity<>(result, HttpStatus.FOUND);

    }

}
