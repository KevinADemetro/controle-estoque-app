package com.kevin.controleequipamentosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kevin.controleequipamentosapi.entity.ItemInventario;

@Repository
public interface ItemInventarioRepository extends JpaRepository<ItemInventario, String>{

}
