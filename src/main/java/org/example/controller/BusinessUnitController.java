package org.example.controller;

import org.example.model.BusinessUnit;
import org.example.service.BusinessUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/business-units")
public class BusinessUnitController {

    private final BusinessUnitService businessUnitService;

    @Autowired
    public BusinessUnitController(BusinessUnitService businessUnitService) {
        this.businessUnitService = businessUnitService;
    }

    @GetMapping
    public ResponseEntity<List<BusinessUnit>> getAllBusinessUnits() {
        List<BusinessUnit> businessUnits = businessUnitService.getAllBusinessUnits();
        return ResponseEntity.ok(businessUnits);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusinessUnit> getBusinessUnitById(@PathVariable Long id) {
        BusinessUnit businessUnit = businessUnitService.getBusinessUnitById(id);
        if (businessUnit != null) {
            return ResponseEntity.ok(businessUnit);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<BusinessUnit> createBusinessUnit(@RequestBody BusinessUnit businessUnit) {
        BusinessUnit createdBusinessUnit = businessUnitService.createBusinessUnit(businessUnit);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBusinessUnit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusinessUnit> updateBusinessUnit(@PathVariable Long id, @RequestBody BusinessUnit businessUnit) {
        BusinessUnit updatedBusinessUnit = businessUnitService.updateBusinessUnit(id, businessUnit);
        if (updatedBusinessUnit != null) {
            return ResponseEntity.ok(updatedBusinessUnit);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBusinessUnit(@PathVariable Long id) {
        boolean deleted = businessUnitService.deleteBusinessUnit(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
