package br.ufscar.dc.dsw.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Editora;
import br.ufscar.dc.dsw.domain.Pacote;
import br.ufscar.dc.dsw.service.spec.IEditoraService;
import br.ufscar.dc.dsw.service.spec.IPacoteService;

@Controller
@RequestMapping("/pacotes")
public class PacoteController {

	@Autowired
	private IPacoteService pacoteService;

	@Autowired
	private IEditoraService editoraService;

	@GetMapping("/cadastrar")
	public String cadastrar(Pacote pacote) {
		return "pacote/cadastro";

	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pacotes", pacoteService.buscarTodos());
		return "pacote/lista";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Pacote pacote, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			
			System.out.println("aaa\naaa\naaa\naaa\naaa\naaa\naaa\naaa\naaa\naaa\naaa\naaa\naaa\n");
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
			System.out.println(pacote.getDescricao());
			System.out.println(pacote.getDuracao());
			System.out.println(pacote.getEditora());
			System.out.println(pacote.getCidade());
			System.out.println(pacote.getEstado());
			System.out.println(pacote.getPais());
			System.out.println(pacote.getValor());
			
			
			
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

	@ModelAttribute("editoras")
	public List<Editora> listaEditoras() {
		return editoraService.buscarTodos();
	}
}