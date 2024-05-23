package com.example.coursework.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@FieldNameConstants
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @JsonIgnoreProperties()
    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private Set<Animal> animals = new LinkedHashSet<>();

}