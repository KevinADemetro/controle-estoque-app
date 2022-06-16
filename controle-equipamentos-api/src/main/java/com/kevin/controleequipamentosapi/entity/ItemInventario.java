package com.kevin.controleequipamentosapi.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.kevin.controleequipamentosapi.entity.enums.Disponibilidade;
import com.kevin.controleequipamentosapi.entity.enums.Status;

import lombok.Data;

@Entity(name = "ItemInventario")
@Table(name = "itens_inventario")
@Data
public class ItemInventario {
	
	@Id
	private String id;
	
	@Column(name = "numero_serie")
	private String numeroDeSerie;
	
	@Column(name = "disponibilidade")
	private Disponibilidade disponibilidade;
	
	@Column(name = "Status")
	private Status status;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "localizacao")
	private String localizacao;
	
	@Column(name = "dt_mvto")
	private LocalDate dataMovimentacao;
}
