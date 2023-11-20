package br.com.rehab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rehab.model.Aluno;


public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
