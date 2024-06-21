package com.thiago.javaGraphql.controller;

import com.thiago.javaGraphql.enums.TipoCombustivelEnum;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
    @QueryMapping
    public List<Consumo> consumoByModelo(@Argument String modelo) {
        return consumoService.consumoByModelo(modelo);
    }
    @QueryMapping
    public List<Consumo> consumoBtDatas(@Argument String dataInicio, @Argument String dataFim) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dataIn = sdf.parse(dataInicio);
        Date fim = sdf.parse(dataFim);
        return consumoService.consumoBtDatas(dataIn, fim);
    }
    @QueryMapping
    public List<Consumo> consumoByMarca(@Argument String marca) {
        return consumoService.consumoByMarca(marca);
    }
    @QueryMapping
    public List<Consumo> consumoByTipo(@Argument TipoCombustivelEnum tipo) {
        return consumoService.consumoByTipo(tipo);
    }
    @QueryMapping
    public List<Consumo> consumoByVeiculoId(@Argument Long id) {
        return consumoService.consumoByVeiculoId(id);
    }

    @MutationMapping
    public Consumo createConsumo(@Argument Consumo consumo) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        consumo.setData(sdf.parse(consumo.getDataAux()));
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
