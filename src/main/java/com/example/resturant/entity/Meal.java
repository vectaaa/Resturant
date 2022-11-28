package com.example.resturant.entity;

import com.example.resturant.entity.enums.MealType;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
//@RequiredArgsConstructor
@Entity
@Table(name = "mealItem")
public class Meal extends BaseEntity{

//    private int quantity;
//    private Double price;

    private String name;
    private Long amount;
    private String description;

    @Lob
    private String imgUrl;

    private Long time ;


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
}
