package com.example.ticketingsystem.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "busType")
public class BusTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "numberPlate")
    private String numberPlate;

    @Column(name="day")
    private Date day;

    @Column(name="time")
    private Time time;

    @Column(name="capacity")
    private int capacity;

    public BusTypes() {

    }

    public BusTypes(String name, String numberPlate, Date day, Time time, int capacity) {
        this.name = name;
        this.numberPlate = numberPlate;
        this.day = day;
        this.time = time;
        this.capacity = capacity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getNumberPlate() {

        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {

        this.numberPlate = numberPlate;
    }

    public Date getDay() {

        return day;
    }

    public void setDay(Date day) {

        this.day = day;
    }

    public Time getTime() {

        return time;
    }

    public void setTime(Time time) {

        this.time = time;
    }

    public int getCapacity() {

        return capacity;
    }

    public void setCapacity(int capacity) {

        this.capacity = capacity;
    }
}
