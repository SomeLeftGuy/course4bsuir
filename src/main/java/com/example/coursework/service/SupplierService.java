package com.example.coursework.service;

import com.example.coursework.model.enums.EventName;
import com.example.coursework.model.entity.Supplier;
import com.example.coursework.repository.SupplierRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierService {
    private final SupplierRepository repository;
    private final LogPublisherService logPublisherService;

    public List<Supplier> getAll() {
        var results = repository.findAll();
        logPublisherService.createAuditLog(EventName.RECEIVED_LIST_SUPPLIERS,"");
        return results;
    }

    public Supplier getById(Integer id) {
        isExistsById(id);
        logPublisherService.createAuditLog(
                EventName.RECEIVED_SUPPLIER,
                "Id: " + id
        );
        return repository.getById(id);
    }

    private void isExistsById(Integer id) {
        if (repository.existsById(id)) {
            throw new EntityNotFoundException(String.format("Supplier %s", id.toString()));
        }
    }
}
