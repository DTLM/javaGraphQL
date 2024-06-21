package com.thiago.javaGraphql.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.thiago.javaGraphql.enums.TipoCombustivelEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Consumo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private Float valor;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	@Column
	private TipoCombustivelEnum tipo;
	@ManyToOne
	private Veiculo veiculo;

	@Transient
	private Long veiculoId;
	@Transient
	private String dataAux;

}
