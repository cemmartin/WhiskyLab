package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping(value = "/distilleries")
    public List<Distillery> getAllDistilleries(){
        return distilleryRepository.findAll();
    }

    @GetMapping(value = "/distilleries/{id}")
    public ResponseEntity<Optional<Distillery>> getIndividualDistillery(@PathVariable Long id){
        return new ResponseEntity<>(distilleryRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/distilleries_in_{region}")
    public ResponseEntity<List<Distillery>> getDistilleriesFromGivenRegion(@PathVariable String region) {
        return new ResponseEntity<>(distilleryRepository.findDistilleriesByRegionEquals(region), HttpStatus.OK);
    }


}
