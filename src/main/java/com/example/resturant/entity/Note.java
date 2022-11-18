package com.example.resturant.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "notes")
public class Note extends BaseEntity{
    @OneToOne
    @JoinColumn(name = "customerId")
    private Customer createdBy;

    @CreationTimestamp
    private Timestamp createdAt;

    private String message;

    @ManyToOne
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;
}
