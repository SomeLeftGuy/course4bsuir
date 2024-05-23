package com.example.coursework.service;

import com.example.coursework.model.entity.Logs;
import com.example.coursework.repository.EmployeeRepository;
import com.example.coursework.repository.LogsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LogService {
    private final LogsRepository repository;
    private final EmployeeRepository employeeRepository;

    public Integer createLog(Logs logs) {
        repository.save(logs);
        return logs.getId();
    }

    public List<Logs> getLogsByEmployeeId(Integer id){
        if (!employeeRepository.existsById(id)) {
            throw new EntityNotFoundException(String.format("Employee %s", id.toString()));
        }

        var employee = employeeRepository.getReferenceById(id);
        var result = repository.findByEmployeeEqualsOrderByIdDesc(employee);
        return result;
    }

    public List<Logs> getLogs(){
        var result = repository.findAll(Sort.by("id").descending());
        return result;
    }
}
