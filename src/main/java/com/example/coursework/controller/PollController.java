package com.example.coursework.controller;

import com.example.coursework.model.entity.Poll;
import com.example.coursework.service.PollService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/polls", produces = "application/json")
public class PollController {
    private final PollService service;

    @GetMapping()
    public List<Poll> getAllPolls() {
        return service.getAll();
    }
}
