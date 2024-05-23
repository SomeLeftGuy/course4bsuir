package com.example.coursework.service;

import com.example.coursework.model.enums.EventName;
import com.example.coursework.model.dto.UpdateEmployeeDTO;
import com.example.coursework.model.entity.Employee;
import com.example.coursework.model.enums.Role;
import com.example.coursework.repository.CellRepository;
import com.example.coursework.repository.EmployeeRepository;
import com.example.coursework.repository.PositionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repository;
    private final CellRepository cellRepository;
    private final PositionRepository positionRepository;
    private final LogPublisherService logPublisherService;

    public Employee save(Employee user) {
        return repository.save(user);
    }

    public Integer create(Employee user) {
        if (repository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Пользователь с таким именем уже существует");
        }

        return save(user).getId();
    }

    public Employee getByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
    }

    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }

    public Employee getCurrentUser() {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUsername(username);
    }

    public void deleteById(Integer id) {
        isExistsById(id);
        repository.deleteById(id);
        logPublisherService.createAuditLog(
                EventName.EMPLOYEE_DELETED,
                "By Id: " + id
        );
    }

    public void updateById(Integer id, UpdateEmployeeDTO dto) {
        isExistsById(id);
        var position = positionRepository.getReferenceById(dto.getPositionId());
        var cells = new HashSet<>(cellRepository.findAllById(dto.getCellIds()));
        var entity = repository.getReferenceById(id);
        entity.setPosition(position);
        entity.setCells(cells);
        entity.setRole(dto.getRole());
        repository.save(entity);
        logPublisherService.createAuditLog(
                EventName.EMPLOYEE_UPDATED,
                "Id: " + id
        );
    }

    @Deprecated
    public void getAdmin() {
        var user = getCurrentUser();
        user.setRole(Role.ROLE_ADMIN);
        save(user);
    }

    public boolean isAdmin(UserDetails userDetails){
        var isAdmin= false;
        if (userDetails instanceof Employee customUserDetails) {
            isAdmin = customUserDetails.getRole().equals(Role.ROLE_ADMIN);
        }
        return isAdmin;
    }


    public void isExistsByUsername(String username) {
        if (repository.existsByUsername(username)) {
            throw new EntityNotFoundException(String.format("Exists Employee %s", username));
        }
    }

    public List<Employee> getAll() {
        var user = getCurrentUser();
        var results = repository.findAllByIdNot(user.getId());
        return results;
    }

    public Employee getById(Integer id) {
        isExistsById(id);
        logPublisherService.createAuditLog(
                EventName.RECEIVED_EMPLOYEE,
                "Id: " + id
        );
        return repository.getById(id);
    }

    private void isExistsById(Integer id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(String.format("Employee %s", id.toString()));
        }
    }
}
