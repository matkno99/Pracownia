package com.s462049.pracownia.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.s462049.pracownia.model.Klienci;
import com.s462049.pracownia.model.Komisy;
import com.s462049.pracownia.repository.KomisyRepository;
import com.s462049.pracownia.service.KomisyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class KomisyServiceImpl implements KomisyService {
    private final KomisyRepository komisyRepository;
    @Autowired
    public KomisyServiceImpl(KomisyRepository komisyRepository) {
        this.komisyRepository = komisyRepository;
    }

    @Override
    public List<Komisy> findAll() {
        return komisyRepository.findAll();
    }

    @Override
    public Optional<Komisy> findById(Long id) {

        return komisyRepository.findById(id);
    }

    @Override
    public Komisy save(Komisy komisy) {

        return komisyRepository.save(komisy);
    }

    @Override
    public Komisy update(Long id, Komisy komisy) {

        return komisyRepository.save(komisy);
    }

    @Override
    public void delete(Long id) {
        komisyRepository.deleteById(id);
    }

    @Override
    public String exportdata() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Komisy>komisy = komisyRepository.findAll();
        return objectMapper.writeValueAsString(komisy);
    }
    @Override
    public void importdata(String data) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Komisy>komisy = objectMapper.readValue(data, new TypeReference<List<Komisy>>() {});
        for(Komisy komis:komisy){
            komisyRepository.save(komis);
        }
    }
}
