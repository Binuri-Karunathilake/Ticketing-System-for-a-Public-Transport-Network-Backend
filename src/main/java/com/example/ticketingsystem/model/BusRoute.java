package com.example.ticketingsystem.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "busRoute")
public class BusRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "stopList")
    private String stopList;

    @Column(name = "ticketPrice")
    private double ticketPrice;

    public BusRoute() {

    }

    public BusRoute(String name, String stopList, double ticketPrice) {
        this.name = name;
        this.stopList = stopList;
        this.ticketPrice = ticketPrice;
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

    public String getStopList() {
        return stopList;
    }

    public void setStopList(String stopList) {
        this.stopList = stopList;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
