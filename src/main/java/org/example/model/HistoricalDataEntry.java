package org.example.model;

import javax.persistence.*;

@Entity
public class HistoricalDataEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;

    private double value;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "key_result_id")
    private KeyResult keyResult;

    public HistoricalDataEntry() {
    }

    public HistoricalDataEntry(Double v, String c){
        value = v;
        comment = c;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String value) {
        this.comment = comment;
    }

    public void setKeyResult(KeyResult keyResult) {
        this.keyResult = keyResult;
    }

    public KeyResult getKeyResult(){ return keyResult;}
}
