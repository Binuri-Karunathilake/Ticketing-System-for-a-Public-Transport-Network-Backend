package com.example.ticketingsystem.controller;

import com.example.ticketingsystem.exceptions.ResourceNotFoundException;
import com.example.ticketingsystem.model.BusTypes;
import com.example.ticketingsystem.repository.BusTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class BusTypesController {

    @Autowired
    private BusTypesRepository BusTypesRepository;

    // Get all BusTypes method
    @GetMapping("/BusTypes")
    public List<BusTypes> getAllBusTypes(){

        return BusTypesRepository.findAll();
    }

    // Add BusType method
    @PostMapping("/BusTypes/AddType")
    public BusTypes createBusTypes(@RequestBody BusTypes BusTypes){
        return BusTypesRepository.save(BusTypes);
    }
    @GetMapping("/BusTypes/{id}")
    public ResponseEntity<BusTypes> getRouteById(@PathVariable Long id) {
        BusTypes BusTypes = BusTypesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bus tpes with given id : " + id + " doesn't exist"));
        return ResponseEntity.ok(BusTypes);
    }

    @PutMapping("/BusTypes/{id}")
    public ResponseEntity<BusTypes> updateBusTypes(@PathVariable Long id, @RequestBody BusTypes BusTypes) {
        BusTypes BusTypes1 = BusTypesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bus types with the given id : " + id + " doesn't exist"));
        BusTypes1.setName(BusTypes.getName());
        BusTypes1.setNumberPlate(BusTypes.getNumberPlate());
        BusTypes1.setDay(BusTypes.getDay());
        BusTypes1.setTime(BusTypes.getTime());
        BusTypes1.setCapacity(BusTypes.getCapacity());

       BusTypes updatedBusTypes = BusTypesRepository.save(BusTypes1);
       return ResponseEntity.ok(updatedBusTypes);
    }

    @DeleteMapping("/BusTypes/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteBusTypes(@PathVariable Long id) {
        BusTypes BusTypes1 = BusTypesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bus types with the given id : " + id + " doesn't exist"));
        BusTypesRepository.delete(BusTypes1);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
