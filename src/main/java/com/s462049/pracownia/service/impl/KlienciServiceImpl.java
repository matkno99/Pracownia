package com.s462049.pracownia.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.s462049.pracownia.model.Klienci;
import com.s462049.pracownia.model.Komisy;
import com.s462049.pracownia.repository.KlienciRepository;
import com.s462049.pracownia.service.KlienciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class KlienciServiceImpl implements KlienciService {
    private final KlienciRepository klienciRepository;
@Autowired
    public KlienciServiceImpl(KlienciRepository klienciRepository) {
        this.klienciRepository = klienciRepository;
    }

    @Override
    public List<Klienci> findAll() {
        return klienciRepository.findAll();
    }

    @Override
    public Optional<Klienci> findById(Long id) {

        return klienciRepository.findById(id);
    }

    @Override
    public Klienci save(Klienci klienci) {

        return klienciRepository.save(klienci);
    }

    @Override
    public Klienci update(Long id, Klienci klienci) {

        return klienciRepository.save(klienci);
    }

    @Override
    public void delete(Long id) {
    klienciRepository.deleteById(id);
    }

    @Override
    public String exportdata() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Klienci>klienci = klienciRepository.findAll();
        return objectMapper.writeValueAsString(klienci);
    }
    @Override
    public void importdata(String data) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Klienci>klienci = objectMapper.readValue(data, new TypeReference<List<Klienci>>() {});
        for(Klienci klient:klienci){
            klienciRepository.save(klient);
        }
    }
}
