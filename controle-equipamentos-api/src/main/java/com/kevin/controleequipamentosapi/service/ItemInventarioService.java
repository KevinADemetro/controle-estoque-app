package com.kevin.controleequipamentosapi.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.kevin.controleequipamentosapi.entity.ItemInventario;
import com.kevin.controleequipamentosapi.entity.enums.Disponibilidade;
import com.kevin.controleequipamentosapi.entity.enums.Status;
import com.kevin.controleequipamentosapi.repository.ItemInventarioRepository;

@Service
public class ItemInventarioService {
	
	@Autowired
	private ItemInventarioRepository repository;
	
	public ItemInventario salvar(ItemInventario item) {
		return repository.save(validar(item));
	}
	
	public List<ItemInventario> listarTodos(){
		return repository.findAll();
	}
	
	public ItemInventario remover(ItemInventario item) {
		item.setStatus(Status.INATIVO);
		return item;
	}
	
	private ItemInventario validar(ItemInventario item) {
		validarId(item.getId());
		validarNumeroDeSerie(item.getNumeroDeSerie());
		validarDiponibilidade(item.getDisponibilidade());
		validarStatus(item.getStatus());
		validarDescricao(item.getDescricao());
		validarLocalizacao(item.getLocalizacao());
		validarDataMovimentacao(item.getDataMovimentacao());
		return item;
	}

	private void validarId(String id) {
		Preconditions.checkNotNull(id);
		Preconditions.checkArgument(id.matches("^[A-Za-z0-9]+\\d+[A-Za-z]+[A-Za-z0-9]*$"));
		Preconditions.checkArgument(repository.findById(id).isEmpty());
		Preconditions.checkArgument(id.length() <= 7);
	}
	
	private void validarNumeroDeSerie(String numeroDeSerie) {
		Preconditions.checkNotNull(numeroDeSerie);
		Preconditions.checkArgument(numeroDeSerie.matches("[0-9]{5}"));
	}
	
	private void validarDiponibilidade(Disponibilidade disponibilidade) {
		Preconditions.checkNotNull(disponibilidade);
	}
	
	private void validarStatus(Status status) {
		Preconditions.checkNotNull(status);
	}
	
	private void validarDescricao(String descricao) {
		Preconditions.checkNotNull(descricao);
		Preconditions.checkArgument(descricao.length() <= 100);
	}
	
	private void validarLocalizacao(String localizacao) {
		Preconditions.checkNotNull(localizacao);
		Preconditions.checkArgument(localizacao.length() <= 100);
		Preconditions.checkArgument(localizacao.length() >= 3);
	}
	
	private void validarDataMovimentacao(LocalDate dataMovimentacao) {
		Preconditions.checkNotNull(dataMovimentacao);
		Preconditions.checkArgument(dataMovimentacao.isAfter(LocalDate.now()) || dataMovimentacao.isEqual(LocalDate.now()));
	}
	
}
