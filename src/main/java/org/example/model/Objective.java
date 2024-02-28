package org.example.model;

import javax.persistence.*;
import java.security.Key;
import java.util.ArrayList;
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
        keyResults = new ArrayList<KeyResult>();
    }

    public Objective(String name) {
        keyResults = new ArrayList<KeyResult>();
        this.name=name;
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

    public void addKeyResult(KeyResult keyResult){ //adds a single KeyResult
        keyResults.add(keyResult);
    }

    public void setKeyResults(List<KeyResult> keyResults) {
        this.keyResults = keyResults;
    } //set s alist with all KeyResults of this Objective, should be used with caution

    @Override
    public String toString() { //prints the data of this Objective
        return "BusinessUnit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Number of KeyResults=" + keyResults.size() +
                '}';
    }

}
