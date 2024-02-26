package org.example.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int size;

    private BusinessUnit businessUnit;

    @OneToMany(mappedBy = "businessUnit", cascade = CascadeType.ALL)
    private List<Objective> objectives;

    public Unit(){

    }

    public Unit(String name, int size, BusinessUnit businessUnit){
        this.name = name;
        this.size = size;
        this.businessUnit = businessUnit;
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

    public BusinessUnit getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(BusinessUnit businessUnit) {
        this.businessUnit = businessUnit;
    }

    public int getObjectiveCount() {return objectives.size();}

    public Objective getObjectives(int number) {
        return getObjectives(number);
    }

    public void setObjective(Objective objective) {
        objectives.add(objective);
    }
}
