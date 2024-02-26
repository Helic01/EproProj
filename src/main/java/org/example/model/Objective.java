package org.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Objective { //OKR-SET

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /*@ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    private BusinessUnit businessUnit;*/

    @OneToMany(mappedBy = "objective", cascade = CascadeType.ALL)
    private List<KeyResult> keyResults;

    // Constructor
    public Objective() {
    }

    // Getters and setters
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

    /*
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public BusinessUnit getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(BusinessUnit businessUnit) {
        this.businessUnit = businessUnit;
    }*/

    public List<KeyResult> getKeyResults() {
        return keyResults;
    }

    public void setKeyResults(List<KeyResult> keyResults) {
        this.keyResults = keyResults;
    }

}
