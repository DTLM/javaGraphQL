package com.thiago.javaGraphql.service;

import com.thiago.javaGraphql.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {

    private VeiculoRepository veiculoRepository;
    @Autowired
    public VeiculoService(VeiculoRepository repository){
        this.veiculoRepository = repository;
    }
}
