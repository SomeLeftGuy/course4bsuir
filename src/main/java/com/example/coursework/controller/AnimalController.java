package com.example.coursework.controller;

import com.example.coursework.model.entity.Animal;
import com.example.coursework.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/animals", produces = "application/json")
public class AnimalController {
    private final AnimalService animalService;

    @GetMapping()
    public List<Animal> getAllAnimals() {
        return animalService.getAll();
    }

    @GetMapping("/{id}")
    public Animal getByAnimalId(@PathVariable Integer id) {
        return animalService.getById(id);
    }
}
