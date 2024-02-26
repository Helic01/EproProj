package org.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class KeyResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double progress;

    private double current;

    private double goal;

    @ManyToOne
    @JoinColumn(name = "objective_id")
    private Objective objective;

    @OneToMany(mappedBy = "keyResult", cascade = CascadeType.ALL)
    private List<HistoricalDataEntry> historicalData;

    public KeyResult() {
    }

    public KeyResult(String name, double progress, Objective objective) {
        this.name = name;
        this.progress = progress;
        this.objective = objective;
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

    public void setProgress(double progress) {
        this.progress = progress;
    }

    public double getCurrent() { return current; }

    public void setCurrent(double current) { this.current = current; }

    public double getGoal() { return goal; }

    public void setGoal(double goal) { this.goal = goal; }

    public Objective getObjective() {
        return objective;
    }

    public void setObjective(Objective objective) {
        this.objective = objective;
    }

    public List<HistoricalDataEntry> getHistoricalData() {
        return historicalData;
    }

    public void setHistoricalData(List<HistoricalDataEntry> historicalData) {
        this.historicalData = historicalData;
    }
}
