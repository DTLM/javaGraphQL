package com.thiago.javaGraphql.controller;

import com.thiago.javaGraphql.model.Veiculo;
import com.thiago.javaGraphql.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/graphql")
public class VeiculoController {

    private VeiculoService  veiculoService;

    @Autowired
    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }
    @QueryMapping
    public Veiculo veiculoById(@Argument Long id){
        return veiculoService.veiculoById(id);
    }

    @QueryMapping
    public List<Veiculo> veiculoByModelo(@Argument String modelo){
        return veiculoService.veiculosByModelo(modelo);
    }
    @QueryMapping
    public List<Veiculo> veiculosAbastecidosComDiesel(){
        return veiculoService.veiculosAbastecidosComDiesel();
    }
    @QueryMapping
    public List<Veiculo> veiculosAbastecidosComGasolina(){
        return veiculoService.veiculosAbastecidosComGasolina();
    }
    @QueryMapping
    public List<Veiculo> veiculosAbastecidosComEtanol(){
        return veiculoService.veiculosAbastecidosComEtanol();
    }
}
