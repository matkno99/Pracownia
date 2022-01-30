package com.s462049.pracownia.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.s462049.pracownia.model.Klienci;
import com.s462049.pracownia.model.Klienci;
import com.s462049.pracownia.service.KlienciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/klienci")
public class KlienciController {
    private final KlienciService klienciService;
    @Autowired
    public KlienciController(KlienciService klienciService) {
        this.klienciService = klienciService;
    }
    @GetMapping("/")
    public ResponseEntity<List<Klienci>> findAll() {
        List<Klienci> allKlienci = this.klienciService.findAll();
        return ResponseEntity.ok()
                .body(allKlienci);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Klienci> findKlient(@PathVariable("id") Long id) {
        Optional<Klienci> klient = this.klienciService.findById(id);
        if(klient.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok()
                .body(klient.get());
    }
    @PostMapping("/")
    public ResponseEntity<Klienci> addKlient(@RequestBody Klienci klient) {
        return new ResponseEntity<>(klienciService.save(klient), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Klienci> deleteKlienci(@PathVariable("id") Long id) {
        Optional<Klienci> klienci = this.klienciService.findById(id);
        if (klienci.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        this.klienciService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Klienci> updateKlient(@PathVariable("id") Long id, @RequestBody Klienci klient) {
        Optional<Klienci> istklient = klienciService.findById(id);
        if(istklient.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        }
        Klienci updatedKlient = this.klienciService.update(id,klient);
        return new ResponseEntity<>(updatedKlient, HttpStatus.OK);
    }
    @GetMapping("/export")
    public ResponseEntity<String> exportData() throws JsonProcessingException {
        String data = klienciService.exportdata();
        return ResponseEntity.ok().body(data);
    }
    @PostMapping("/import")
    public ResponseEntity<String> importData(@RequestBody String data) throws JsonProcessingException {
        klienciService.importdata(data);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
