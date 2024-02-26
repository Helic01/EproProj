package org.example.model;

import javax.persistence.*;
import java.util.ArrayList;
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

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Unit> units;

    public BusinessUnit() {
        objectives = new ArrayList<Objective>();
    }

    public BusinessUnit(String name, int size, Company company) {
        this.name = name;
        this.size = size;
        this.company = company;
        objectives = new ArrayList<Objective>();
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

    public int getObjectiveCount() {return objectives.size();}

    public Objective getObjectives(int number) {
        return getObjectives(number);
    }

    public void setObjective(Objective objective) {
        objectives.add(objective);
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
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
