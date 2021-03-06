package br.com.orion.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.orion.model.Conta;
import br.com.orion.model.enumarate.StatusEnum;
import br.com.orion.model.filter.ContaFilter;
import br.com.orion.service.ContaService;

@Controller
@RequestMapping("/contas")
public class ContaController {

	@Autowired
	private ContaService contaService;

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("conta");
		mv.addObject(new Conta());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String list(@Validated Conta conta, Errors erros, RedirectAttributes atributes) {
		if (erros.hasErrors()) {
			return "conta";
		}
		contaService.salvar(conta);
		atributes.addFlashAttribute("mensagem", "Conta gravada com sucesso.");
		return "redirect:/contas/novo";
	}

	@RequestMapping
	public ModelAndView pesquisa(@ModelAttribute("contaFilter") ContaFilter filter) {
		List<Conta> contas = contaService.findByNome(filter.getNome());
		ModelAndView mv = new ModelAndView("pesquisa");
		mv.addObject("contas", contas);
		return mv;
	}

	@RequestMapping("{id}")
	public ModelAndView edicao(@PathVariable("id") Conta conta) {
		// Conta conta = contaRepository.findOne(id); Spring com JPARepository
		// detecta
		// a necessidade da busca através do parametro @PathVariable("id")s
		ModelAndView mv = new ModelAndView("conta");
		mv.addObject(conta);
		return mv;

	}

	@ModelAttribute("statusEnuns")
	public List<StatusEnum> findAll() {
		return Arrays.asList(StatusEnum.values());
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long id, RedirectAttributes atributes) {
		contaService.excluir(id);
		atributes.addFlashAttribute("mensagem", "Conta excluída com sucesso.");
		return "redirect:/contas";
	}

	@RequestMapping(value = "/{id}/ativar", method = RequestMethod.PUT)
	public @ResponseBody String ativar(@PathVariable Long id) {
		return contaService.ativarConta(id);
	}
}
