package com.example.coursework.controller;

import com.example.coursework.model.entity.Logs;
import com.example.coursework.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/logs", produces = "application/json")
public class LogsController {
    private final LogService logService;

    @GetMapping("/employee/{id}")
    public List<Logs> getLogsByEmployeeId(@PathVariable Integer id) {
        return logService.getLogsByEmployeeId(id);
    }

    @GetMapping("/all")
    public List<Logs> getLogs() {
        return logService.getLogs();
    }
}
