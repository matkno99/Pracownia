package com.s462049.pracownia.service.impl;

import com.s462049.pracownia.model.Klienci;
import com.s462049.pracownia.repository.KlienciRepository;
import com.s462049.pracownia.service.KlienciService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class KlienciServiceImpl implements KlienciService {
    private final KlienciRepository klienciRepository;

    public KlienciServiceImpl(KlienciRepository klienciRepository) {
        this.klienciRepository = klienciRepository;
    }

    @Override
    public List<Klienci> findAll() {
        return klienciRepository.findAll();
    }

    @Override
    public Optional<Klienci> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Klienci save(Klienci Klienci) {
        return null;
    }

    @Override
    public Klienci update(Long id, Klienci Klienci) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
