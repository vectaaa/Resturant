package com.example.resturant.dto;

import com.example.resturant.entity.Order;
import com.example.resturant.entity.Payment;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class CustomerDto {

    private Long id;
    @NotEmpty
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

   //The list of Orders and Payments DTO's
    private List<Order> orders;
    private List<Payment> payments;

}
