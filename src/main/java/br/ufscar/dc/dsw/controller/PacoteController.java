package br.ufscar.dc.dsw.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Agencia;
import br.ufscar.dc.dsw.domain.Pacote;
import br.ufscar.dc.dsw.security.UsuarioDetails;
import br.ufscar.dc.dsw.service.spec.IAgenciaService;
import br.ufscar.dc.dsw.service.spec.IPacoteService;

@Controller
@RequestMapping("/pacotes")
public class PacoteController {

	@Autowired
	private IPacoteService pacoteService;

	@Autowired
	private IAgenciaService agenciaService;

	@GetMapping("/cadastrar")
	public String cadastrar(Pacote pacote) {
		return "pacote/cadastro";
	}

	@GetMapping("/listar/todos")
	public String listar(ModelMap model) {
		model.addAttribute("pacotes", pacoteService.buscarTodos());
		return "pacote/lista";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Pacote pacote, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "pacote/cadastro";
		}

		pacoteService.salvar(pacote);
		attr.addFlashAttribute("sucess", "pacote.create.sucess");
		return "redirect:/pacotes/listar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pacote", pacoteService.buscarPorId(id));
		return "pacote/cadastro";
	}

	@PostMapping("/editar")
	public String editar(@Valid Pacote pacote, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "pacote/cadastro";
		}

		pacoteService.salvar(pacote);
		attr.addFlashAttribute("sucess", "pacote.edit.sucess");
		return "redirect:/pacotes/listar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		pacoteService.excluir(id);
		attr.addFlashAttribute("sucess", "pacote.delete.sucess");
		return "redirect:/pacotes/listar";
	}

	@ModelAttribute("agencias")
	public List<Agencia> listaAgencias() {
		return agenciaService.buscarTodos();
	}

	private Agencia getAgencia() {
		UsuarioDetails agenciaDetails = (UsuarioDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = agenciaDetails.getUsername();
		Agencia agencia = agenciaService.buscarPorLogin(username);
		return agencia;
	}

	@GetMapping("/listar")
	public String listaPacotesPorAgencia(ModelMap model){
		model.addAttribute("pacotes", pacoteService.buscarTodosPorAgencia(this.getAgencia()));
		return "pacote/lista";
	}
}
