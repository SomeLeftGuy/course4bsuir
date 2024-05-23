package com.example.coursework.controller;

import com.example.coursework.model.dto.CreateDescriptionAnimalDTO;
import com.example.coursework.model.entity.DescriptionAnimal;
import com.example.coursework.service.DescriptionAnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/description-animal", produces = "application/json")
public class DescriptionAnimalController {
    private final DescriptionAnimalService descriptionAnimalService;

    @GetMapping("/animal/{id}")
    public List<DescriptionAnimal> getDescriptionByAnimalId(@PathVariable Integer id) {
        return descriptionAnimalService.getByAnimalId(id);
    }

    @PostMapping()
    public Integer create(@RequestBody CreateDescriptionAnimalDTO dto) {
        return descriptionAnimalService.create(dto);
    }
}
