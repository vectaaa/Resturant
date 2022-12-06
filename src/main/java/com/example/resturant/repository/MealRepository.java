package com.example.resturant.repository;

import com.example.resturant.entity.Meal;
import com.example.resturant.entity.enums.MealType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long> {

    @Query("from Meal where mealType = :mealType")
    List<Meal> findMealsByMealType(@Param("mealType") String mealType);

    List<Meal> findByOrderByMealType();

    List<Meal> findMealsByRestaurantId(Long id);
}
