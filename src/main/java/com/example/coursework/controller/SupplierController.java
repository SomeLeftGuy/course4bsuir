package com.example.coursework.controller;

import com.example.coursework.model.entity.Supplier;
import com.example.coursework.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/suppliers", produces = "application/json")
public class SupplierController {
    private final SupplierService supplierService;

    @GetMapping()
    public List<Supplier> getAllSuppliers() {
        return supplierService.getAll();
    }

    @GetMapping("/{id}")
    public Supplier getBySupplierId(@PathVariable Integer id) {
        return supplierService.getById(id);
    }
}
