package com.example.coursework.service;

import com.example.coursework.model.entity.Cell;
import com.example.coursework.repository.CellRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CellService {
    private final CellRepository repository;

    public List<Cell> getAll() {
        return repository.findAll();
    }
}
