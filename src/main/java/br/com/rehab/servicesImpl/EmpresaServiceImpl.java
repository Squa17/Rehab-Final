package br.com.rehab.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rehab.model.Empresa;
import br.com.rehab.repository.EmpresaRepository;
import br.com.rehab.services.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {
	
	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	public List<Empresa> getAllEmpresas() {
		return empresaRepository.findAll();
		}

	@Override
	@Transactional(readOnly = true)
	public Empresa getEmpresaById(Long id) {
		return empresaRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Empresa saveEmpresa(Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	@Override
	public Empresa updateEmpresa(Long id, Empresa empresaAtualizada) {
		Empresa empresaExistente = empresaRepository.findById(id).orElse(null);
		if (empresaExistente != null) { 
			empresaExistente.setNome(empresaAtualizada.getNome());
			empresaExistente.setCnpj(empresaAtualizada.getCnpj());
			empresaExistente.setEndereco(empresaAtualizada.getEndereco());
			empresaExistente.setContato(empresaAtualizada.getContato());
			return empresaRepository.save(empresaExistente);
		} else { 
			throw new RuntimeException("empresa com o ID" + id + "não encontrada.");
		}
	}

	@Override
	public void deleteEmpresa(Long id) {
		empresaRepository.deleteById(id);
	}

	
}