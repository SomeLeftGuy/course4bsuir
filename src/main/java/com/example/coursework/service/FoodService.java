package com.example.coursework.service;

import com.example.coursework.model.enums.EventName;
import com.example.coursework.model.entity.Animal;
import com.example.coursework.model.entity.Food;
import com.example.coursework.model.entity.Supplier;
import com.example.coursework.repository.AnimalRepository;
import com.example.coursework.repository.FoodRepository;
import com.example.coursework.repository.SupplierRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository repository;
    private final SupplierRepository supplierRepository;
    private final AnimalRepository animalRepository;
    private final LogPublisherService logPublisherService;

    public List<Food> getBySupplierId(Integer supplierId) {
        isEntityExistsById(supplierRepository, supplierId);
        var supplier = getSupplierById(supplierId);
        var foods = repository.getBySuppliersEquals(supplier);
        logPublisherService.createAuditLog(
                EventName.RECEIVED_LIST_OF_SUPPLIED_FOOD_SUPPLIERS,
                "Id: " + supplier.getId().toString()
        );
        return foods;
    }

    public List<Food> getByAnimalId(Integer animalId) {
        isEntityExistsById(animalRepository, animalId);
        var animal = getAnimalById(animalId);
        var foods = repository.getByAnimalsEquals(animal);
        logPublisherService.createAuditLog(
                EventName.RECEIVED_LIST_OF_FOOD_FOR_AN_ANIMAL,
                "Id: " + animal.getId().toString()
        );
        return foods;
    }

    private void isEntityExistsById(JpaRepository repository, Integer id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(String.format("NotExists %s", id.toString()));
        }
    }

    private Supplier getSupplierById(@NonNull Integer id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Supplier %s", id.toString())));
    }

    private Animal getAnimalById(@NonNull Integer id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Animal %s", id.toString())));
    }
}
