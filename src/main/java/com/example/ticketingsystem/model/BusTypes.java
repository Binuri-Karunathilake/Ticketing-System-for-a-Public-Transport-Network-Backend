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
    private String day;

    @Column(name="capacity")
    private int capacity;

    @Column(name="route")
    private long route;



    public BusTypes() {

    }

    public BusTypes(String name, String numberPlate, String day, int capacity, long route) {
        this.name = name;
        this.numberPlate = numberPlate;
        this.day = day;
        this.capacity = capacity;
        this.route = route;
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

    public String getDay() {

        return day;
    }

    public void setDay(String day) {

        this.day = day;
    }

    public int getCapacity() {

        return capacity;
    }

    public long getRoute() {
        return route;
    }

    public void setRoute(long route) {
        this.route = route;
    }

    public void setCapacity(int capacity) {

        this.capacity = capacity;
    }
}
