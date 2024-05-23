package com.example.coursework.service;

import com.example.coursework.model.enums.EventName;
import com.example.coursework.model.dto.CreateDescriptionAnimalDTO;
import com.example.coursework.model.entity.Animal;
import com.example.coursework.model.entity.DescriptionAnimal;
import com.example.coursework.repository.AnimalRepository;
import com.example.coursework.repository.DescriptionAnimalRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DescriptionAnimalService {
    private final DescriptionAnimalRepository repository;
    private final AnimalRepository animalRepository;
    private final LogPublisherService logPublisherService;

    public List<DescriptionAnimal> getByAnimalId(Integer animalId) {
        var animal = getAnimalById(animalId);
        var descriptions = repository.findByAnimalEquals(animal);
        logPublisherService.createAuditLog(
                EventName.RECEIVED_DESCRIPTION_FOR_AN_ANIMAL,
                "Id = " + animal.getId().toString());
        return descriptions;
    }

    public Integer create(CreateDescriptionAnimalDTO dto) {
        var animal = animalRepository.getReferenceById(dto.getAnimalId());
        var entity = new DescriptionAnimal().builder()
                .animal(animal)
                .age(dto.getAge())
                .mass(dto.getMass())
                .height(dto.getHeight())
                .lastUpdate(LocalDate.now())
                .build();
        repository.save(entity);
        logPublisherService.createAuditLog(
                EventName.CREATED_ANIMAL_DESCRIPTION,
                "Id = " + animal.getId().toString());
        return entity.getId();
    }

    private Animal getAnimalById(@NonNull Integer id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("DescriptionAnimal %s", id.toString())));
    }
}
