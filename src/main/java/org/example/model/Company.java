package org.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<BusinessUnit> businessUnits;

    // Constructors
    public Company() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BusinessUnit> getBusinessUnits() {
        return businessUnits;
    }

    public void setBusinessUnits(List<BusinessUnit> businessUnits) {
        this.businessUnits = businessUnits;
    }
}
