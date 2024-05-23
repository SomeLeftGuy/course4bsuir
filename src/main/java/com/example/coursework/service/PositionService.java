package com.example.coursework.service;

import com.example.coursework.model.entity.Position;
import com.example.coursework.repository.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionService {
    private final PositionRepository repository;

    public List<Position> getAll() {
        return repository.findAll();
    }
}
