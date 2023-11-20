package br.com.rehab.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import br.com.rehab.model.Curso;
import br.com.rehab.repository.CursoRepository;
import br.com.rehab.services.CursoService;

@Service
public class CursoServiceImpl implements CursoService{
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Override
	public List<Curso> getAllCursos() {
		return cursoRepository.findAll();
		}

	@Override
	@Transactional(readOnly = true)
	public Curso getCursoById(Long id) {
		return cursoRepository.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Curso saveCurso(Curso curso) {
		return cursoRepository.save(curso);
	}
	
	@Override
	public Curso updateCurso(Long id, Curso cursoAtualizada) {
		Curso cursoExistente = cursoRepository.findById(id).orElse(null);
		if (cursoExistente != null) { 
			cursoExistente.setNome(cursoAtualizada.getNome());
			cursoExistente.setInstrutor(cursoAtualizada.getInstrutor());
			return cursoRepository.save(cursoExistente);
		} else { 
			throw new RuntimeException("Curso com o ID" + id + "não encontrada.");
		}
	}

	@Override
	public void deleteCurso(Long id) {
		cursoRepository.deleteById(id);
	}
}
