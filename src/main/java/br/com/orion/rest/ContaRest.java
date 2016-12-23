package br.com.orion.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.orion.model.Conta;
import br.com.orion.service.ContaService;

@RestController
@RequestMapping(value = "/api/contas")
public class ContaRest {

	@Autowired
	private ContaService contaService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Conta> getFilms() {
		List<Conta> contas = contaService.findAll();
		return contas;
	}

	// @RequestMapping(method = RequestMethod.POST)
	// public void addFilm(@RequestBody @Valid Conta film) {
	// DUMMY_FILMS.add(film);
	// }
}
