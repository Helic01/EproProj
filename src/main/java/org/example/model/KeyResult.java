package org.example.model;

import org.springframework.data.util.Pair;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class KeyResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;

    private double progress=0.0; //in percent
    private double current=0.0;
    private double goal=0.1;
    private double confidenceLevel;

    private Objective buObjective;

    @OneToMany(mappedBy = "keyResult", cascade = CascadeType.ALL)
    private List<HistoricalDataEntry> historicalData;

    public KeyResult() {
    }

    public KeyResult(String name, double current, double goal) {
        this.name = name;
        this.current = current;
        this.goal = goal;
        historicalData = new ArrayList<HistoricalDataEntry>();
        if(goal<=0.0){
            goal=1.0;
            System.out.println("Goal cant be 0 or lower. Goal set to 1.0");
        }
        progress = current/goal;
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

    public double getProgress() {
        return progress;
    } //returns the progress in percent

    public double getCurrent() { return current; }

    public void setCurrent(double current, String comment) { //sets the current Progress, and adds it into the historical Data with a required comment, updates progress
        if(comment.equals("")){
            System.out.println("Error, Comment cant be empty");
        }
        else{
            this.current = current;
            historicalData.add(new HistoricalDataEntry(current, comment));
            if(goal!=0.0)
                progress = current/goal;
        }

    }

    public double getGoal() { return goal; }

    public void setGoal(double goal) {
        if(goal>0.0)
            this.goal = goal;
        else
            System.out.println("Goal cannot be 0 or lower.");
    }

    public void setBUObjective(Objective buObjective){ //sets Parent Objective
        this.buObjective=buObjective;
    }

    public Objective getBuObjective(){ //returns Parent Objective
        return buObjective;
    }


    public List<HistoricalDataEntry> getHistoricalData() { //returns a List with the whole history of this KeyResult
        return historicalData;
    }

    public void addHistoricalDataEntry(String comment){ //adds an HistoricalDataEntry without changing the current Progress of this KeyResult
        historicalData.add(new HistoricalDataEntry(current,comment));
    }

    public void setHistoricalData(List<HistoricalDataEntry> historicalData) {//sets the whole history, should be used with caution
        this.historicalData = historicalData;
    }

    public double getConfidenceLevel() {
        return confidenceLevel;
    }

    public void setConfidenceLevel(double confidenceLevel) {
        this.confidenceLevel = confidenceLevel;
    }

}
