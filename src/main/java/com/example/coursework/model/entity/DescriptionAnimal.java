package com.example.coursework.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@Table(name = "description_animal")
public class DescriptionAnimal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "last_update", nullable = false)
    private LocalDate lastUpdate;

    @Column(name = "height", nullable = false)
    private Double height;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "mass", nullable = false)
    private Double mass;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "AnimalId", nullable = false)
    private Animal animal;

}