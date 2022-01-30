package com.s462049.pracownia.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.s462049.pracownia.model.Komisy;
import com.s462049.pracownia.model.Samochody;
import com.s462049.pracownia.repository.SamochodyRepository;
import com.s462049.pracownia.service.SamochodyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SamochodyServiceImpl implements SamochodyService {
    private final SamochodyRepository samochodyRepository;
    @Autowired
    public SamochodyServiceImpl(SamochodyRepository samochodyRepository) {
        this.samochodyRepository = samochodyRepository;
    }

    @Override
    public List<Samochody> findAll() {
        return samochodyRepository.findAll();
    }

    @Override
    public Optional<Samochody> findById(Long id) {

        return samochodyRepository.findById(id);
    }

    @Override
    public Samochody save(Samochody samochody) {


        return samochodyRepository.save(samochody);
    }


    @Override
    public Samochody update(Long id, Samochody samochody) {

        return samochodyRepository.save(samochody);
    }

    @Override
    public void delete(Long id) {
        samochodyRepository.deleteById(id);
    }

    @Override
    public String exportdata() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Samochody>samochody = samochodyRepository.findAll();
        return objectMapper.writeValueAsString(samochody);
    }
    @Override
    public void importdata(String data) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Samochody>samochody = objectMapper.readValue(data, new TypeReference<List<Samochody>>() {});
        for(Samochody samochod:samochody){
            samochodyRepository.save(samochod);
        }
    }
}
