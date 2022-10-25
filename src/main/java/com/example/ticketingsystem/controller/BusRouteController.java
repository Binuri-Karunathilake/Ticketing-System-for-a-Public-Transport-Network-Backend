package com.example.ticketingsystem.controller;

import com.example.ticketingsystem.model.BusRoute;
import com.example.ticketingsystem.repository.BusRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class BusRouteController {

    @Autowired
    private BusRouteRepository busRouteRepository;

    /** Get all Employees method */
    @GetMapping("/busRoutes")
    public List<BusRoute> getAllRoutes() {
        return busRouteRepository.findAll();
    }

    /** Add employee method */
    @PostMapping("/busRoutes/addRoute")
    public BusRoute createBusRoute(@RequestBody BusRoute busRoute){
        return busRouteRepository.save(busRoute);
    }

}
