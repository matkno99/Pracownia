package com.s462049.pracownia.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.s462049.pracownia.model.Komisy;
import com.s462049.pracownia.model.Komisy;
import com.s462049.pracownia.service.KomisyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/komisy")
public class KomisyController {
    private final KomisyService komisyService;
    @Autowired
    public KomisyController(KomisyService komisyService) {
        this.komisyService = komisyService;
    }
    @GetMapping("/")
    public ResponseEntity<List<Komisy>> findAll() {
        List<Komisy> allKomisy = this.komisyService.findAll();
        return ResponseEntity.ok()
                .body(allKomisy);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Komisy> findKomis(@PathVariable("id") Long id) {
        Optional<Komisy> komis = this.komisyService.findById(id);
        if(komis.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok()
                .body(komis.get());
    }
    @PostMapping("/")
    public ResponseEntity<Komisy> addKomis(@RequestBody Komisy komis) {
        return new ResponseEntity<>(komisyService.save(komis), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Komisy> deleteKomisy(@PathVariable("id") Long id) {
        Optional<Komisy> komisy = this.komisyService.findById(id);
        if (komisy.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        this.komisyService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Komisy> updateKomis(@PathVariable("id") Long id, @RequestBody Komisy komis) {
        Optional<Komisy> istkomis = komisyService.findById(id);
        if(istkomis.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);

    }
        Komisy updatedKomis = this.komisyService.update(id,komis);
        return new ResponseEntity<>(updatedKomis, HttpStatus.OK);
    }
    @GetMapping("/export")
    public ResponseEntity<String> exportData() throws JsonProcessingException {
        String data = komisyService.exportdata();
        return ResponseEntity.ok().body(data);
    }
    @PostMapping("/import")
    public ResponseEntity<String> importData(@RequestBody String data) throws JsonProcessingException {
        komisyService.importdata(data);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

