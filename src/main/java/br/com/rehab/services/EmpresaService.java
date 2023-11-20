package br.com.rehab.services;

import java.util.List;


import br.com.rehab.model.Empresa;




public interface EmpresaService {

List<Empresa> getAllEmpresas();
	
	Empresa getEmpresaById(Long id);
	
	Empresa saveEmpresa(Empresa empresa);
	
	Empresa updateEmpresa(Long id, Empresa empresaAtualizada);
	
	void deleteEmpresa(Long id);
}