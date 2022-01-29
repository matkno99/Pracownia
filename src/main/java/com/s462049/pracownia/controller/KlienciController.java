package com.s462049.pracownia.controller;

import com.s462049.pracownia.model.Klienci;
import com.s462049.pracownia.service.KlienciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
