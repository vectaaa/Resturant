package com.example.resturant.dto;

import com.example.resturant.entity.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class RestaurantDto implements Serializable {

    private String ownersName;
    private String restaurantName;
    private String restaurantAddress;
    private String email;
    private String phoneNumber;
    private Attach cacFileName;
    private String password;
    private Set<Order> orders;
    private Timestamp createdAt;
    private List<Payment> payments;
    private Set<Note> notes;
    private Set<Customer> customers;
}
