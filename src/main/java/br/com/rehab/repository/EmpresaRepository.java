package br.com.rehab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rehab.model.Empresa;



@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
	
}