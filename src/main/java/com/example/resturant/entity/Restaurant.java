package com.example.resturant.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Restaurant extends BaseEntity {
    private String ownersName;

    @Column(unique = true, nullable = false)
    private String email;
    private String restaurantName;
    private String restaurantAddress;
    private String phoneNumber;
    private String cac;
    private String password;


    @OneToMany(mappedBy = "restaurant")
    @ToString.Exclude
    private Set<Order> orders;

    @OneToMany(mappedBy = "restaurant")
    @ToString.Exclude
    //We use set because we don't need duplicate
    private Set<Meal> meal;

    @OneToMany(mappedBy = "restaurant")
    @ToString.Exclude
    //We use list because we don't mind duplicate
    private List<Payment> payments;

    @OneToMany(mappedBy = "restaurant")
    @ToString.Exclude
    private Set<Note> notes;

    @ManyToMany
    @JoinTable(name = "restaurant_customer",
            joinColumns = @JoinColumn(name = "restaurantId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "customerId", referencedColumnName = "id"))
    @ToString.Exclude
    private Set<Customer> customers;

}