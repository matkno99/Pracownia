package com.s462049.pracownia.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.s462049.pracownia.model.Komisy;

import java.util.List;
import java.util.Optional;

public interface KomisyService {
    List<Komisy> findAll();

    Optional<Komisy> findById(Long id);

    Komisy save(Komisy komisy);

    Komisy update(Long id, Komisy komisy);

    void delete(Long id);

    String exportdata() throws JsonProcessingException;

    void importdata(String data) throws JsonProcessingException;
}
