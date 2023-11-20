package br.com.rehab.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.rehab.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
