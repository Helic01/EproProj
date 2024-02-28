package org.example.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int size; //Employee count

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<BusinessUnit> businessUnits;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Objective> objectives;

    // Constructors
    public Company() {
        businessUnits = new ArrayList<BusinessUnit>();
        objectives = new ArrayList<Objective>();
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<BusinessUnit> getBusinessUnits() {
        return businessUnits;
    } //returns a list with all BUs

    public void setBusinessUnits(List<BusinessUnit> businessUnits) {
        this.businessUnits = businessUnits;
    } //sets a List with all BUs

    public void addBusinessUnit(BusinessUnit businessUnits) {
        this.businessUnits.add(businessUnits);
    } //adds one BU

    public int getObjectiveCount() {return objectives.size();}

    public Objective getObjective(int number){ return objectives.get(number);} //returns one specific Objective

    public List<Objective> getObjectiveList(){return objectives;} //returns a list with all Objectives

    public void addObjective(Objective objective){ objectives.add(objective);}

    @Override
    public String toString() { //prints the data of this Company
        return "BusinessUnit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", objectives=" + objectives +
                '}';
    }
}
