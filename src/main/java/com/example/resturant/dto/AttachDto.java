package com.example.resturant.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttachDto {
    private long id;
    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private String path;
    private String type;
    private long size;
}
