package br.com.rehab.services;

import java.util.List;

import br.com.rehab.model.Categoria;

public interface CategoriaService {
	 
	List<Categoria> getAllCategorias();
	
	Categoria getCategoriaById(Long id);
	
	Categoria saveCategoria(Categoria categoria);
	
	Categoria updateCategoria(Long id, Categoria categoriaAtualizada);
	
	void deleteCategoria(Long id);
}