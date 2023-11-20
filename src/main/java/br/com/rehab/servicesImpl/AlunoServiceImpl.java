package br.com.rehab.servicesImpl;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import br.com.rehab.model.Aluno;
import br.com.rehab.model.Curso;
import br.com.rehab.repository.AlunoRepository;
import br.com.rehab.services.AlunoService;
import br.com.rehab.services.CursoService;

@Service
public class AlunoServiceImpl implements AlunoService {
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private CursoService cursoService;
	
	@Override
	public List<Aluno> getAllAluno() {
		return alunoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Aluno getAlunoById(Long id) {
		return alunoRepository.findById(id).orElse(null);
	}


	@Override
	public Aluno saveAluno(Aluno aluno, Set<Long> cursoIds) {
		Set<Curso> cursos = cursoIds.stream()
				.map(cursoService::getCursoById)
				.filter(Objects::nonNull)
				.collect(Collectors.toSet());
		
		aluno.setCursos(cursos);
		
		return alunoRepository.save(aluno);
	}

	@Override
	public Aluno updateAluno(Long id, Aluno alunoAtualizado) {
		Aluno alunoExistente = alunoRepository.findById(id).orElse(null);
		if (alunoExistente != null) { 
			alunoExistente.setNome(alunoAtualizado.getNome());
			alunoExistente.setCpf(alunoAtualizado.getCpf());
			alunoExistente.setEmail(alunoAtualizado.getEmail());
			alunoExistente.setTelefone(alunoAtualizado.getTelefone());
			alunoExistente.setImgUrl(alunoAtualizado.getImgUrl());
			
			Set<Curso> cursosAtualizadas = alunoAtualizado.getCursos();
			for ( Curso curso : cursosAtualizadas) { 
				curso.getAlunos().add(alunoExistente);
			}
			
			alunoExistente.setCursos(cursosAtualizadas);
			
			return alunoRepository.save(alunoExistente);
		} else { 
			throw new RuntimeException("Aluno com o ID" + id + "não encontrada.");
		}
	}

	@Override
	public void deleteAluno(Long id) {
		alunoRepository.deleteById(id);
	}




	
}
