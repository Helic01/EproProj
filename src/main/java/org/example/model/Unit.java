package org.example.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Unit { //A Unit below the BusinessUnits
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int size = 0; //Employee count

    private BusinessUnit businessUnit; //Parent BU

    @OneToMany(mappedBy = "businessUnit", cascade = CascadeType.ALL)
    private List<Objective> objectives;

    public Unit(){
        objectives = new ArrayList<Objective>();
        name="";
    }

    public Unit(String name, BusinessUnit businessUnit){
        this.name = name;
        this.businessUnit = businessUnit;
        objectives = new ArrayList<Objective>();
    }

    public Unit(String name, int size, BusinessUnit businessUnit){
        this.name = name;
        this.size = size;
        this.businessUnit = businessUnit;
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

    public BusinessUnit getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(BusinessUnit businessUnit) {
        this.businessUnit = businessUnit;
    }

    public int getObjectiveCount() {return objectives.size();}

    public Objective getObjective(int number) {
        return objectives.get(number);
    } //returns a single Objective

    public void addObjective(Objective objective){
        objectives.add(objective);
    }

    public List<Objective> getObjectiveList(){return objectives;} //returns a list with all Objectives

    @Override
    public String toString() { //prints the data of this unit
        return "Unit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", Parent-BusinessUnit=" + businessUnit.getName() +
                ", objectives=" + objectives +
                '}';
    }
}
