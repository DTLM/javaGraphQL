package com.thiago.javaGraphql.service;

import com.thiago.javaGraphql.model.Veiculo;
import com.thiago.javaGraphql.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    private VeiculoRepository veiculoRepository;
    @Autowired
    public VeiculoService(VeiculoRepository repository){
        this.veiculoRepository = repository;
    }

    public Veiculo veiculoById(Long id){
        return (veiculoRepository.findById(id).isPresent())? veiculoRepository.findById(id).get(): null;
    }

    public List<Veiculo> veiculosByModelo(String modelo){
        return veiculoRepository.findByModelo(modelo);
    }
    public List<Veiculo> veiculosAbastecidosComDiesel(){
        return veiculoRepository.veiculosAbastecidosComDiesel();
    }
    public List<Veiculo> veiculosAbastecidosComGasolina(){
        return veiculoRepository.veiculosAbastecidosComGasolina();
    }
    public List<Veiculo> veiculosAbastecidosComEtanol(){
        return veiculoRepository.veiculosAbastecidosComEtanol();
    }
}
