package com.example.coursework.controller;

import com.example.coursework.model.dto.UpdateEmployeeDTO;
import com.example.coursework.model.entity.Employee;
import com.example.coursework.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/employees", produces = "application/json")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping()
    public List<Employee> getAllEmployees() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee getByEmployeeId(@PathVariable Integer id) {
        return employeeService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        employeeService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody UpdateEmployeeDTO dto) {
        employeeService.updateById(id, dto);
    }
}
