package com.s462049.pracownia.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.s462049.pracownia.model.Samochody;
import com.s462049.pracownia.model.Samochody;
import com.s462049.pracownia.service.SamochodyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/samochody")
public class SamochodyController {
    private final SamochodyService samochodyService;
    @Autowired
    public SamochodyController(SamochodyService samochodyService) {
        this.samochodyService = samochodyService;
    }
    @GetMapping("/")
    public ResponseEntity<List<Samochody>> findAll() {
        List<Samochody> allSamochody = this.samochodyService.findAll();
        return ResponseEntity.ok()
                .body(allSamochody);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Samochody> findSamochod(@PathVariable("id") Long id) {
        Optional<Samochody> samochod = this.samochodyService.findById(id);
        if(samochod.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok()
                .body(samochod.get());
    }
    @PostMapping("/")
    public ResponseEntity<Samochody> addSamochod(@RequestBody Samochody samochod) {
        return new ResponseEntity<>(samochodyService.save(samochod), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Samochody> deleteSamochod(@PathVariable("id") Long id) {
        this.samochodyService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Samochody> updateSamochod(@PathVariable("id") Long id, @RequestBody Samochody samochod) {
        Optional<Samochody> istsamochod = samochodyService.findById(id);
        if(istsamochod.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        }
        Samochody updatedSamochod = this.samochodyService.update(id,samochod);
        return new ResponseEntity<>(updatedSamochod, HttpStatus.OK);
    }
    @GetMapping("/export")
    public ResponseEntity<String> exportData() throws JsonProcessingException {
        String data = samochodyService.exportdata();
        return ResponseEntity.ok().body(data);
    }
    @PostMapping("/import")
    public ResponseEntity<String> importData(@RequestBody String data) throws JsonProcessingException {
        samochodyService.importdata(data);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

