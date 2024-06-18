package com.thiago.javaGraphql.repository;

import com.thiago.javaGraphql.model.Consumo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumoRepository extends CrudRepository<Consumo, Long> {
}
