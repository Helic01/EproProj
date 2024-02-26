package org.example.service;

import org.example.model.BusinessUnit;
import org.example.repository.BusinessUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessUnitService {

    private final BusinessUnitRepository businessUnitRepository;

    @Autowired
    public BusinessUnitService(BusinessUnitRepository businessUnitRepository) {
        this.businessUnitRepository = businessUnitRepository;
    }

    public List<BusinessUnit> getAllBusinessUnits() {
        return businessUnitRepository.findAll();
    }

    public BusinessUnit getBusinessUnitById(Long id) {
        return businessUnitRepository.findById(id).orElse(null);
    }

    public BusinessUnit createBusinessUnit(BusinessUnit businessUnit) {
        return businessUnitRepository.save(businessUnit);
    }

    public BusinessUnit updateBusinessUnit(Long id, BusinessUnit businessUnit) {
        if (businessUnitRepository.existsById(id)) {
            businessUnit.setId(id);
            return businessUnitRepository.save(businessUnit);
        }
        return null;
    }

    public boolean deleteBusinessUnit(Long id) {
        if (businessUnitRepository.existsById(id)) {
            businessUnitRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
