package com.thiago.javaGraphql.repository;

import com.thiago.javaGraphql.model.Veiculo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends CrudRepository<Veiculo, Long> {

    @Query(value = "SELECT v FROM Veiculo v where v.modelo like ?1")
    List<Veiculo> findByModelo(String modelo);
    @Query(value = "SELECT new Veiculo(v.id, v.marca, v.modelo, v.placa, v.anoFabricacao, v.anoModelo) FROM Veiculo v, Consumo c where c.tipo = 0")
    List<Veiculo> veiculosAbastecidosComDiesel();
    @Query(value = "SELECT new Veiculo(v.id, v.marca, v.modelo, v.placa, v.anoFabricacao, v.anoModelo) FROM Veiculo v, Consumo c where c.tipo = 2")
    List<Veiculo> veiculosAbastecidosComGasolina();
    @Query(value = "SELECT new Veiculo(v.id, v.marca, v.modelo, v.placa, v.anoFabricacao, v.anoModelo) FROM Veiculo v, Consumo c where c.tipo = 1")
    List<Veiculo> veiculosAbastecidosComEtanol();
}
