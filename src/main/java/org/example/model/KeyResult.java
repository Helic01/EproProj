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

    private double progress=0.0;

    private double current=0.0;

    private double goal=0.1;


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
    }


    public double getCurrent() { return current; }

    public void setCurrent(double current, String comment) {
        this.current = current;
        historicalData.add(new HistoricalDataEntry(current, comment));
        if(goal!=0)
            progress = current/goal;
    }

    public double getGoal() { return goal; }

    public void setGoal(double goal) {
            this.goal = goal;
    }


    public List<HistoricalDataEntry> getHistoricalData() {
        return historicalData;
    }

    public void setHistoricalData(List<HistoricalDataEntry> historicalData) {
        this.historicalData = historicalData;
    }
}
