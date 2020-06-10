package com.example.JavaReack.healthcare.controller;

import com.example.JavaReack.healthcare.model.BloodPressureMeasurement;
import com.example.JavaReack.healthcare.repository.MeasurementRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("api/hc")
public class MeasurementController {

    private final MeasurementRepository repository;

    public MeasurementController(MeasurementRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/bp")
    Collection<BloodPressureMeasurement> getBPMeasurements() {
        return repository.findAll();
    }

    @GetMapping("/bp/{id}")
    ResponseEntity<BloodPressureMeasurement> getBPMeasurement(@PathVariable Long id) {
        Optional<BloodPressureMeasurement> byIdOpt = repository.findById(id);
        return byIdOpt.map(opt -> ResponseEntity.ok().body(opt)).
                orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/bp")
    ResponseEntity<BloodPressureMeasurement> createMeasurement(@RequestBody BloodPressureMeasurement measurement) throws URISyntaxException {
        BloodPressureMeasurement result = repository.save(measurement);
        return ResponseEntity.created(new URI("api/hc/bp/" + result.getId())).build();
    }

}


