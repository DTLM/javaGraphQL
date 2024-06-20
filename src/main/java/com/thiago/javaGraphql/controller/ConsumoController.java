package com.thiago.javaGraphql.controller;

import com.thiago.javaGraphql.model.Consumo;
import com.thiago.javaGraphql.model.Veiculo;
import com.thiago.javaGraphql.service.ConsumoService;
import com.thiago.javaGraphql.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConsumoController {

    private ConsumoService consumoService;
    private VeiculoService veiculoService;

    @Autowired
    public ConsumoController(ConsumoService consumoService, VeiculoService veiculoService) {
        this.consumoService = consumoService;
        this.veiculoService = veiculoService;
    }

    @QueryMapping
    public Consumo consumoById(@Argument Long id) {
        return consumoService.consumoById(id);
    }

    @MutationMapping
    public Consumo createConsumo(@Argument Consumo consumo) {
        return consumoService.createConsumo(consumo);
    }

    @MutationMapping
    public Consumo updateConsumo(@Argument Consumo consumo) {
        return consumoService.updateConsumo(consumo);
    }

    @MutationMapping
    public void deleteConsumo(@Argument Long id) {
        consumoService.deleteConsumo(id);
    }

    @SchemaMapping
    public Veiculo veiculo(Consumo consumo) {
        return veiculoService.veiculoById(consumo.getVeiculo().getId());
    }
}
