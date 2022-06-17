package com.kevin.controleequipamentosapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.controleequipamentosapi.entity.ItemInventario;
import com.kevin.controleequipamentosapi.service.ItemInventarioService;

@RestController
@RequestMapping("/item")
public class ItemInventarioController {
	
	@Autowired
	private ItemInventarioService service;
	
	@GetMapping
	public List<ItemInventario> listar(){
		return service.listarTodos();
	}
	
	@PostMapping
	public ItemInventario salvar(@RequestBody ItemInventario item) {
		return service.salvar(item);
	}
	
	@DeleteMapping
	public ItemInventario remover(@RequestBody ItemInventario item){
		return service.remover(item);
	}
}
