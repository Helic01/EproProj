package org.example.model;

import javax.persistence.*;

@Entity
public class HistoricalDataEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date = "";

    private double value;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "key_result_id")
    private KeyResult keyResult;

    public HistoricalDataEntry() {
    }

    public HistoricalDataEntry(Double v, String c){
        if(!c.equals("")){
            value = v;
            comment = c;
        }
        else{
            System.out.println("Comment cannot be empty");
        }
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

    public void setComment(String comment) { //only sets Comment if not empty
        if(comment.equals(""))
            System.out.println("Comment cannot be empty");
        else
            this.comment = comment;
    }

    public void setKeyResult(KeyResult keyResult) {
        this.keyResult = keyResult;
    } //sets the KeyResult this entry belongs to

    public KeyResult getKeyResult(){ return keyResult;}

    @Override
    public String toString() { //prints the data of this HistoricalDataEntry
        return "BusinessUnit{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", comment=" + comment +
                ", date=" + date +
                '}';
    }
}
