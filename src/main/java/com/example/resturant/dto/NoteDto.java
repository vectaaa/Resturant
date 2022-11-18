package com.example.resturant.dto;

import com.example.resturant.entity.Customer;
import com.example.resturant.entity.Restaurant;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class NoteDto {

    private Customer createdBy;
    private Timestamp createdAt;

    private String message;
    private Restaurant restaurant;
}
