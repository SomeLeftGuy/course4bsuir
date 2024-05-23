package com.example.coursework.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateDescriptionAnimalDTO {
    private Integer age;
    private Double height;
    private Double mass;
    private Integer animalId;
}
