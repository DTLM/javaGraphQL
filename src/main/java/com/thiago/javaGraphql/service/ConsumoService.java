package com.thiago.javaGraphql.service;

import com.thiago.javaGraphql.repository.ConsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumoService {
    private ConsumoRepository consumoRepository;
    @Autowired
    public ConsumoService(ConsumoRepository repository) {
        this.consumoRepository = repository;
    }
}
