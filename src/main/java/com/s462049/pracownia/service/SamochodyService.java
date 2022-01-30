package com.s462049.pracownia.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.s462049.pracownia.model.Samochody;

import java.util.List;
import java.util.Optional;

public interface SamochodyService {
    List<Samochody> findAll();

    Optional<Samochody> findById(Long id);

    Samochody save(Samochody samochody);

    Samochody update(Long id, Samochody samochody);

    void delete(Long id);

    String exportdata() throws JsonProcessingException;

    void importdata(String data) throws JsonProcessingException;
}
