package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.WhiskyTrackerApplication;
import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/distillerys")
    public ResponseEntity<List<Distillery>> getAllDistillerys(){
        return new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/distillerys/{region}")
    public ResponseEntity getDistillerysByRegion(@PathVariable String region){
        return new ResponseEntity<>(distilleryRepository.findDistillerysByRegion(region), HttpStatus.OK);
    }

    @GetMapping(value = "/distillerys/whiskys")
    public ResponseEntity<List<Whisky>>findWhiskyFromDistilleryByAge(
            @RequestParam(name = "age") int age) {
        return new ResponseEntity<>(whiskyRepository.findByDistillery_RegionAndDistillery_Whiskies_Age(age),HttpStatus.OK);
    }


}
