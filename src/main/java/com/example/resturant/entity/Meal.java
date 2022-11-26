package com.example.resturant.entity;

import com.example.resturant.entity.enums.MealType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "mealItem")
public class Meal extends BaseEntity{

//    private int quantity;
//    private Double price;

    private String name;
    private Long amount;
    private String description;
    
    private String imgUrl;
    private Long time ;


    @ManyToOne
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;

    //We use @Enumerated here to save the enum value of mealtype as a text in the DB.
    @Enumerated(EnumType.STRING)
    private MealType mealType;

    @ManyToOne //Ma
    @JoinColumn(name = "cartId")
    private Order order;
}
