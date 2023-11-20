package br.com.rehab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rehab.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
