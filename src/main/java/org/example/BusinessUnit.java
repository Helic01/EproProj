package org.example;
import javax.persistence.*;
import java.util.List;

@Entity
public class BusinessUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int size;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "businessUnit", cascade = CascadeType.ALL)
    private List<Objective> objectives;

    // Constructors, getters, and setters
}