package com.example.ticketingsystem.controller;

import com.example.ticketingsystem.exceptions.ResourceNotFoundException;
import com.example.ticketingsystem.model.BusRoute;
import com.example.ticketingsystem.repository.BusRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @CrossOrigin
    @GetMapping("/busRoutes/{id}")
    public ResponseEntity<BusRoute> getRouteById(@PathVariable Long id){
        BusRoute busRoute = busRouteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bus route with given id : " + id + " doesn't exist"));
        return ResponseEntity.ok(busRoute);
    }

    @PutMapping("/busRoutes/{id}")
    public ResponseEntity<BusRoute> updateBusRoute(@PathVariable Long id, @RequestBody BusRoute busRoute) {
        BusRoute busRoute1 = busRouteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bus route with the given id : " + id + " doesn't exist"));
        busRoute1.setName(busRoute.getName());
        busRoute1.setStopList(busRoute.getStopList());
        busRoute1.setTicketPrice(busRoute.getTicketPrice());

        BusRoute updatedBusRoute = busRouteRepository.save(busRoute1);
        return ResponseEntity.ok(updatedBusRoute);
    }

    @DeleteMapping("/busRoutes/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteBusRoute(@PathVariable Long id) {
        BusRoute busRoute1 = busRouteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bus route with the given id : " + id + " doesn't exist"));
        busRouteRepository.delete(busRoute1);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    /** Add employee method */
    @PostMapping("/busRoutes/addRoute")
    public BusRoute createBusRoute(@RequestBody BusRoute busRoute){
        return busRouteRepository.save(busRoute);
    }

}
