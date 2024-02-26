package org.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Objective {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double progress;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

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

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<KeyResult> getKeyResults() {
        return keyResults;
    }

    public void setKeyResults(List<KeyResult> keyResults) {
        this.keyResults = keyResults;
    }

}
