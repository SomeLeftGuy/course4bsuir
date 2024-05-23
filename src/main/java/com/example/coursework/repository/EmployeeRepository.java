package com.example.coursework.repository;

import com.example.coursework.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByUsername(String username);

    List<Employee> findAllByIdNot(Integer id);
    boolean existsByUsername(String username);
}