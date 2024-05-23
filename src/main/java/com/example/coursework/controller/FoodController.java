package com.example.coursework.controller;

import com.example.coursework.model.entity.Food;
import com.example.coursework.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/foods", produces = "application/json")
public class FoodController {
    private final FoodService foodService;

    @GetMapping("/supplier/{id}")
    public List<Food> getFoodBySupplierId(@PathVariable Integer id) {
        return foodService.getBySupplierId(id);
    }

    @GetMapping("/animal/{id}")
    public List<Food> getFoodByAnimalId(@PathVariable Integer id) {
        return foodService.getByAnimalId(id);
    }
}
