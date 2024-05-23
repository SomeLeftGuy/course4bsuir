package com.example.coursework.controller;

import com.example.coursework.model.entity.Cell;
import com.example.coursework.service.CellService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/cells", produces = "application/json")
public class CellController {
    private final CellService service;

    @GetMapping()
    public List<Cell> getAllCells() {
        return service.getAll();
    }
}
