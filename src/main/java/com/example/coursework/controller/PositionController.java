package com.example.coursework.controller;

import com.example.coursework.model.entity.Position;
import com.example.coursework.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/positions", produces = "application/json")
public class PositionController {
    private final PositionService service;

    @GetMapping()
    public List<Position> getAllPositions() {
        return service.getAll();
    }
}
