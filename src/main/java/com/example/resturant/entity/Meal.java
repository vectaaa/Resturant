package com.example.resturant.entity;

import com.example.resturant.entity.enums.MealType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@ToString
//@RequiredArgsConstructor
@Entity
@Table(name = "mealItem")
public class Meal extends BaseEntity {

//    private int quantity;
//    private Double price;

    private String name;
    private Long amount;
    private String description;

    @Lob
    @Column(length = 4000) private String imgUrl;

    private Long time;


    @OneToOne
    private Attach mealImage;

    @ManyToOne
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;

    //We use @Enumerated here to save the enum value of mealtype as a text in the DB.
    @Enumerated(EnumType.STRING)
    private MealType mealType;

    @ManyToOne //Ma
    @JoinColumn(name = "cartId")
    private Order order;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Meal meal = (Meal) o;
        return getId() != null && Objects.equals(getId(), meal.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Attach getMealImage() {
        return mealImage;
    }

    public void setMealImage(Attach mealImage) {
        this.mealImage = mealImage;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }


    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
