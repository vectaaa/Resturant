package com.example.resturant.services;

public interface Order {

    void addMealToOrder();

    void removeMealFromOrder();

    void cancelOrder();

    void orderHistoryInADay();

    void totalOrderPrice();
}
