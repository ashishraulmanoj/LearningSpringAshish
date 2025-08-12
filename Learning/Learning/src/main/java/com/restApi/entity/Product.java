package com.restApi.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private long id;
    private String name;
    private String description;
    private double price;

}
