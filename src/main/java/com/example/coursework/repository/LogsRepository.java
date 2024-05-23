package com.example.coursework.repository;

import com.example.coursework.model.entity.Employee;
import com.example.coursework.model.entity.Logs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogsRepository extends JpaRepository<Logs, Integer> {
    List<Logs> findByEmployeeEqualsOrderByIdDesc(Employee employee);
}
