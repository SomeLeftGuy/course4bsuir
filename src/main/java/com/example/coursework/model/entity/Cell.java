package com.example.coursework.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@FieldNameConstants
@Table(name = "cell")
public class Cell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "height", nullable = false)
    private Double height;

    @Column(name = "width", nullable = false)
    private Double width;

    @Column(name = "long", nullable = false)
    private Double longField;

    @JsonIgnoreProperties()
    @JsonIgnore
    @OneToMany(mappedBy = "cell")
    private Set<Animal> animals = new LinkedHashSet<>();

    @JsonIgnoreProperties()
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "employee_cell",
            joinColumns = @JoinColumn(name = "cell_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id")
    )
    Set<Employee> employees = new HashSet<>();

}