package com.example.coursework.service;

import com.example.coursework.model.enums.EventName;
import com.example.coursework.model.entity.Animal;
import com.example.coursework.repository.AnimalRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalService {
    private final AnimalRepository repository;
    private final LogPublisherService logPublisherService;

    public List<Animal> getAll() {
        logPublisherService.createAuditLog(EventName.RECEIVED_LIST_ANIMALS,"");
        return repository.findAll();
    }

    public Animal getById(Integer id) {
        isExistsById(id);
        logPublisherService.createAuditLog(
                EventName.RECEIVED_ANIMAL,
                "Id: " + id);
        var res = repository.getById(id);
        return res;
    }

    private Animal getEntityById(@NonNull Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Animal %s", id.toString())));
    }

    private void isExistsById(Integer id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(String.format("Animal %s", id.toString()));
        }
    }
}
