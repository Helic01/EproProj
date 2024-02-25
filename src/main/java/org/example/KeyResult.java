package org.example;
import javax.persistence.*;
import java.util.List;

@Entity
public class KeyResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double progress;

    @ManyToOne
    @JoinColumn(name = "objective_id")
    private Objective objective;

    @OneToMany(mappedBy = "keyResult", cascade = CascadeType.ALL)
    private List<HistoricalDataEntry> historicalData;

    // Constructors, getters, and setters
}