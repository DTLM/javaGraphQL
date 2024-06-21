package com.thiago.javaGraphql.repository;

import com.thiago.javaGraphql.enums.TipoCombustivelEnum;
import com.thiago.javaGraphql.model.Consumo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ConsumoRepository extends CrudRepository<Consumo, Long> {

    @Query("select c from Consumo c inner join c.veiculo v where v.modelo like ?1")
    List<Consumo> consumoByModelo(String modelo);

    @Query("select c from Consumo c where c.data between ?1 and ?2")
    List<Consumo> consumoBtDatas(Date dataInical, Date dataFinal);
    @Query("select c from Consumo c inner join c.veiculo v where v.marca like ?1")
    List<Consumo> consumoByMarca(String marca);
    @Query("select c from Consumo c where tipo = ?1")
    List<Consumo> consumoByTipo(TipoCombustivelEnum tipo);
    @Query("select c from Consumo c inner join c.veiculo v where v.id = ?1")
    List<Consumo> consumoByVeiculoId(Long id);
}
