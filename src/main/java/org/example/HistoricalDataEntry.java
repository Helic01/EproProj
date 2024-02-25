package org.example;
import javax.persistence.*;

@Entity
public class HistoricalDataEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;

    private double value;

    @ManyToOne
    @JoinColumn(name = "key_result_id")
    private KeyResult keyResult;

    // Constructors, getters, and setters
}