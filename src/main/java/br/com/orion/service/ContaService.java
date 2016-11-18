package br.com.orion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.orion.model.Conta;
import br.com.orion.model.enumarate.StatusEnum;
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
	
	public String ativarConta(Long id){
		Conta conta = contaRepository.getOne(id);
		conta.setStatus(StatusEnum.ATIVA);
		salvar(conta);
		return StatusEnum.ATIVA.getDescricao();
	}
	
	public List<Conta> findByNome(String nome){
		return contaRepository.findByNomeContaining(nome);
	}
	
}
