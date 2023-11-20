package br.com.rehab.services;

import java.util.List;
import java.util.Set;



import br.com.rehab.model.Aluno;

public interface AlunoService {
	
List<Aluno> getAllAluno();
	
	Aluno getAlunoById(Long id);
	
	Aluno saveAluno(Aluno aluno, Set<Long> cursoIds);
	
	Aluno updateAluno(Long id, Aluno alunoAtualizado);
	
	void deleteAluno(Long id);
	
}
