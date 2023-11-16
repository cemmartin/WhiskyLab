package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getAllWhiskies(){
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/{id}")
    public Optional<Whisky> getIndividualWhisky(@PathVariable Long id){
        return whiskyRepository.findById(id);
    }

//    @PostMapping(value = "/whiskies")
//    public ResponseEntity<Whisky> postWhisky(@RequestBody Whisky whisky){
//        whiskyRepository.save(whisky);
//        return new ResponseEntity<>(whisky, HttpStatus.CREATED);
//    }

    @GetMapping(value = "/whiskies_from_{year}")
    public ResponseEntity<List<Whisky>> getWhiskiesFromGivenYear(@PathVariable int year) {
        return new ResponseEntity<>(whiskyRepository.findWhiskiesByYearEquals(year), HttpStatus.OK);
    }
}
