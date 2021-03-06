package com.s462049.pracownia.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.s462049.pracownia.model.Klienci;

import java.util.List;
import java.util.Optional;

public interface KlienciService {
    List<Klienci> findAll();

    Optional<Klienci> findById(Long id);

    Klienci save(Klienci klienci);

    Klienci update(Long id, Klienci klienci);

    void delete(Long id);

    String exportdata() throws JsonProcessingException;

    void importdata(String data) throws JsonProcessingException;
}

