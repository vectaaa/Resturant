package com.example.resturant.dto;

import com.example.resturant.entity.Attach;
import com.example.resturant.entity.Order;
import com.example.resturant.entity.Restaurant;
import com.example.resturant.entity.enums.MealType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Lob;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MealDto {

    private  String name;
    public  Long amount;
    private String description;

    @Lob
    private String imageUrl;
    private Long time ;
    private String mealType;
    private Long restaurantId;






//    private Restaurant restaurant;
//
//    private Order order;

}
