package br.com.orion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.orion.model.Conta;
import br.com.orion.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;

	public void salvar(Conta conta) {
			contaRepository.save(conta);
	}
	
	public List<Conta> findAll(){
		return contaRepository.findAll();
	}
	
	public void excluir(Long id){
		contaRepository.delete(id);
	}
}
