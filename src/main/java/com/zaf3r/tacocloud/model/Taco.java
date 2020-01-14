package com.zaf3r.tacocloud.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private Date createdAt;

    @ManyToMany(targetEntity = Ingredient.class)
    private List<String> ingredients;

    @PrePersist
    void createdAt(){
        this.createdAt = new Date();
    }

}
