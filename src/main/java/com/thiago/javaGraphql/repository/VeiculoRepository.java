package com.thiago.javaGraphql.repository;

import com.thiago.javaGraphql.model.Veiculo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends CrudRepository<Veiculo, Long> {
}
