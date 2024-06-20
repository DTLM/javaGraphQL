package com.thiago.javaGraphql.service;

import com.thiago.javaGraphql.model.Consumo;
import com.thiago.javaGraphql.repository.ConsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsumoService {
    private ConsumoRepository consumoRepository;
    @Autowired
    public ConsumoService(ConsumoRepository repository) {
        this.consumoRepository = repository;
    }
    public Consumo consumoById(Long id){
        return (consumoRepository.findById(id).isPresent())? consumoRepository.findById(id).get(): null;
    }

    public Consumo createConsumo(Consumo consumo){
        return consumoRepository.save(consumo);
    }
    public Consumo updateConsumo(Consumo consumo){
        Optional<Consumo> consumoAux = consumoRepository.findById(consumo.getId());
        return consumoAux.map(value -> consumoRepository.save(value)).orElseGet(() -> consumoRepository.save(consumo));
    }

    public void deleteConsumo(Long id) {
        consumoRepository.deleteById(id);
    }
}
