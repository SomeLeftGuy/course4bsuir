package com.example.coursework.service;

import com.example.coursework.model.entity.Poll;
import com.example.coursework.repository.PollRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PollService {
    private final PollRepository repository;

    public List<Poll> getAll() {
        return repository.findAll();
    }
}
