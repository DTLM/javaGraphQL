package com.thiago.javaGraphql.service;

import com.thiago.javaGraphql.enums.TipoCombustivelEnum;
import com.thiago.javaGraphql.model.Consumo;
import com.thiago.javaGraphql.model.Veiculo;
import com.thiago.javaGraphql.repository.ConsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ConsumoService {
    private ConsumoRepository consumoRepository;
    private VeiculoService veiculoService;
    @Autowired
    public ConsumoService(ConsumoRepository repository, VeiculoService  veiculoService) {
        this.consumoRepository = repository;
        this.veiculoService = veiculoService;
    }
    public Consumo consumoById(Long id){
        return (consumoRepository.findById(id).isPresent())? consumoRepository.findById(id).get(): null;
    }

    public List<Consumo> consumoByModelo(String modelo){
        return consumoRepository.consumoByModelo(modelo);
    }
    public List<Consumo> consumoByMarca(String marca){
        return consumoRepository.consumoByMarca(marca);
    }
    public List<Consumo> consumoByTipo(TipoCombustivelEnum tipo){
        return consumoRepository.consumoByTipo(tipo);
    }
    public List<Consumo> consumoByVeiculoId(Long id){
        return consumoRepository.consumoByVeiculoId(id);
    }

    public List<Consumo> consumoBtDatas(Date dataInical, Date dataFinal){
        return consumoRepository.consumoBtDatas(dataInical, dataFinal);
    }

    public Consumo createConsumo(Consumo consumo){
        Veiculo veiculo = this.veiculoService.veiculoById(consumo.getVeiculoId());
        consumo.setVeiculo(veiculo);
        return consumoRepository.save(consumo);
    }
    public Consumo updateConsumo(Consumo consumo){
        Optional<Consumo> consumoAux = consumoRepository.findById(consumo.getVeiculoId());
        return consumoAux.map(value -> consumoRepository.save(value)).orElseGet(() -> consumoRepository.save(consumo));
    }

    public void deleteConsumo(Long id) {
        consumoRepository.deleteById(id);
    }
}
