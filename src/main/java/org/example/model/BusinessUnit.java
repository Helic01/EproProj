package org.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class BusinessUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int size;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "businessUnit", cascade = CascadeType.ALL)
    private List<Objective> objectives;

    public BusinessUnit() {
    }

    public BusinessUnit(String name, int size, Company company, List<Objective> objectives) {
        this.name = name;
        this.size = size;
        this.company = company;
        this.objectives = objectives;
    }

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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Objective> getObjectives() {
        return objectives;
    }

    public void setObjectives(List<Objective> objectives) {
        this.objectives = objectives;
    }

    @Override
    public String toString() {
        return "BusinessUnit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", company=" + company +
                ", objectives=" + objectives +
                '}';
    }
}
