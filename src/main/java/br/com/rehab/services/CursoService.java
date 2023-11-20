package br.com.rehab.services;

import java.util.List;

import br.com.rehab.model.Curso;



public interface CursoService {
	List<Curso> getAllCursos();
	
	Curso getCursoById(Long id);
	
	Curso saveCurso(Curso curso);
	
	Curso updateCurso(Long id, Curso cursoAtualizada);
	
	void deleteCurso(Long id);
}
