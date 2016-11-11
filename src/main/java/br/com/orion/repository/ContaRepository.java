package br.com.orion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.orion.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{

}
