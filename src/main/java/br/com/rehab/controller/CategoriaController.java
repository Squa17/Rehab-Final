package br.com.rehab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.rehab.model.Categoria;
import br.com.rehab.services.CategoriaService;


@Controller
@RequestMapping("/categorias")
public class CategoriaController {
 
	@Autowired
	private CategoriaService categoriaService;
 
	// Listar
	@GetMapping
	public String listCategorias(Model model) {
		List<Categoria> categorias = categoriaService.getAllCategorias();
		model.addAttribute("categorias", categorias);
		return "ListarCategorias";
	}
 
	// Formulário de criação
	@GetMapping("/novo")
	public String showFormForAdd(Model model) {
		Categoria categoria = new Categoria();
		model.addAttribute("categoria", categoria);
		return "categoriaForm";
	}
 
	// Persistencia da criação
	@PostMapping("/save")
	public String saveCategoria(@ModelAttribute("categoria") Categoria categoria) {
		categoriaService.saveCategoria(categoria);
		return "redirect:/categorias";
	}
 
	// Formulário de edição
	@GetMapping("/editar/{id}")
	public String showFormForUpdate(@PathVariable Long id, Model model) {
		Categoria categoria = categoriaService.getCategoriaById(id);
		model.addAttribute("categoria", categoria);
		return "editarCategoria";
	}
 
	// Persistencia da edição
	@PostMapping("/editar/{id}")
	public String updateCategoria(@PathVariable Long id, @ModelAttribute("categoria")
	Categoria categoria) {
		categoriaService.updateCategoria(id, categoria);
		return "redirect:/categorias";
	}
	
	// Excluir categoria
	@GetMapping("/deletar/{id}")
	public String deleteCategoria(@PathVariable Long id) {
		categoriaService.deleteCategoria(id);
		return "redirect:/categorias";
	}
 
}

