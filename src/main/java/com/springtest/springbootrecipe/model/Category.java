package com.springtest.springbootrecipe.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@EqualsAndHashCode(exclude = "recipes")
@Data
@Entity
public class Category {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

}
