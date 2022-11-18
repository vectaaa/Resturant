package com.example.resturant.dto;

import com.example.resturant.entity.Order;
import com.example.resturant.entity.Restaurant;
import com.example.resturant.entity.enums.MealType;
import lombok.Data;

@Data
public class MealDto {
    private String name;
    private int quantity;
    private Double price;

    private Restaurant restaurant;
    private MealType mealType;
    private Order order;

}
