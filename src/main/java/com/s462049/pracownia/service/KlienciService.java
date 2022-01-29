package com.s462049.pracownia.service;

import com.s462049.pracownia.model.Klienci;

import java.util.List;
import java.util.Optional;

public interface KlienciService {
    List<Klienci> findAll();

    Optional<Klienci> findById(Long id);

    Klienci save(Klienci Klienci);

    Klienci update(Long id, Klienci Klienci);

    void delete(Long id);
}

