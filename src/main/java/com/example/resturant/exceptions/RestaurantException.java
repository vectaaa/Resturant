package com.example.resturant.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RestaurantException extends RuntimeException {
    public RestaurantException() {

    }

    public RestaurantException(String message) {
        super(message);
    }
}
