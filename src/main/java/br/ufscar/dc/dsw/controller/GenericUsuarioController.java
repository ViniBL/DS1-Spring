package br.ufscar.dc.dsw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.GenericUsuario;
import br.ufscar.dc.dsw.service.spec.IGenericUsuarioService;

@Controller
@RequestMapping("/genericUsuarios")
public class GenericUsuarioController {
	
	@Autowired
	private IGenericUsuarioService service;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping("/cadastrar")
	public String cadastrar(GenericUsuario genericUsuario) {
		return "genericUsuario/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("genericUsuarios",service.buscarTodos());
		return "genericUsuario/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid GenericUsuario genericUsuario, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "genericUsuario/cadastro";
		}

		System.out.println("password = " + genericUsuario.getPassword());
		
		genericUsuario.setPassword(encoder.encode(genericUsuario.getPassword()));
		service.salvar(genericUsuario);
		attr.addFlashAttribute("sucess", "genericUsuario.create.sucess");
		return "redirect:/genericUsuarios/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("genericUsuario", service.buscarPorId(id));
		return "genericUsuario/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid GenericUsuario genericUsuario, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "genericUsuario/cadastro";
		}

		System.out.println(genericUsuario.getPassword());
		
		service.salvar(genericUsuario);
		attr.addFlashAttribute("sucess", "genericUsuario.edit.sucess");
		return "redirect:/genericUsuarios/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		model.addAttribute("sucess", "genericUsuario.delete.sucess");
		return listar(model);
	}
}
