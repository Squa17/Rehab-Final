package br.com.rehab.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

//model

@Entity
@Table(name = "categoria")
public class Categoria {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@Column(columnDefinition = "TEXT")
	private String descricao;
	
	@ManyToMany(mappedBy = "categorias")
	private Set<Produto> produtos = new HashSet<>();
	
	public Categoria() {
	}
	
	public Categoria(Long id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}
 
	public Long getId() {
		return id;
	}
 
	public void setId(Long id) {
		this.id = id;
	}
 
	public String getNome() {
		return nome;
	}
 
	public void setNome(String nome) {
		this.nome = nome;
	}
 
	public String getDescricao() {
		return descricao;
	}
 
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}