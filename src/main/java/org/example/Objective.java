package org.example;
import javax.persistence.*;

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

    // Constructors, getters, and setters
}