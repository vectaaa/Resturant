package com.example.resturant.dto;

import com.example.resturant.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto {

    private String ownersName;
    private String restaurantName;
    private String restaurantAddress;
    private String email;
    private String phoneNumber;
    private Attach cacFileName;
    private String password;
//    private String cacFileName;
//    private String cacFileType;
//    private String cacFileSize;





    private Set<Order> orders;
    private Timestamp createdAt;
    private List<Payment> payments;
    private Set<Note> notes;
    private Set<Customer> customers;
}
