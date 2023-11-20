package br.com.rehab.model;

import java.util.HashSet;
import java.util.Set;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "curso")	
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String instrutor;
	
	@ManyToMany(mappedBy = "cursos", cascade = {CascadeType.ALL})
	private Set<Aluno> alunos = new HashSet<>();
	
	public Curso() {
		
	}

	
	public Curso(Long id, String nome, String instrutor) {
		super();
		this.id = id;
		this.nome = nome;
		this.instrutor = instrutor;
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


	public String getInstrutor() {
		return instrutor;
	}


	public void setInstrutor(String instrutor) {
		this.instrutor = instrutor;
	}

	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	
	
}
