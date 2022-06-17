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
		return repository.save(item);
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
		Preconditions.checkNotNull(id, "O id deve ser obrigatório");
		Preconditions.checkArgument(id.matches("^[A-Za-z0-9]+\\d+[A-Za-z]+[A-Za-z0-9]*$"), "O id deve ter letras e números");
		Preconditions.checkArgument(repository.findById(id).isEmpty(), "O id deve ser único");
		Preconditions.checkArgument(id.length() <= 7, "O id não pode ter mais 7 caracteres");
	}
	
	private void validarNumeroDeSerie(String numeroDeSerie) {
		Preconditions.checkNotNull(numeroDeSerie, "Número de série é obrigatório");
		Preconditions.checkArgument(numeroDeSerie.matches("[0-9]{5}"), "Número de série deve conter o formato NNNNN");
	}
	
	private void validarDiponibilidade(Disponibilidade disponibilidade) {
		Preconditions.checkNotNull(disponibilidade, "Disponibilidade é obrigatório");
	}
	
	private void validarStatus(Status status) {
		Preconditions.checkNotNull(status, "Status é obrigatório");
	}
	
	private void validarDescricao(String descricao) {
		Preconditions.checkNotNull(descricao, "Descrição é obrigatória");
		Preconditions.checkArgument(descricao.length() <= 100, "Descrição não pode ter mais que 100 caracteres");
	}
	
	private void validarLocalizacao(String localizacao) {
		Preconditions.checkNotNull(localizacao, "Localização é obrigatória");
		Preconditions.checkArgument(localizacao.length() <= 100, "Localização não pode ter mais que 100 caracteres");
		Preconditions.checkArgument(localizacao.length() >= 3, "Localização não pode ter menos que 3 caracteres");
	}
	
	private void validarDataMovimentacao(LocalDate dataMovimentacao) {
		Preconditions.checkNotNull(dataMovimentacao, "Data de movimentação é obrigatória");
		Preconditions.checkArgument(dataMovimentacao.isAfter(LocalDate.now()) || dataMovimentacao.isEqual(LocalDate.now()), "Data de movimentação não pode ser menor que a data de hoje");
	}
	
}
