package br.ufscar.dc.dsw.controller;

//import java.text.SimpleDateFormat;
//import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Compra;
import br.ufscar.dc.dsw.domain.Pacote;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.security.UsuarioDetails;
import br.ufscar.dc.dsw.service.spec.ICompraService;
import br.ufscar.dc.dsw.service.spec.IPacoteService;
import br.ufscar.dc.dsw.service.spec.IUsuarioService;


@Controller
@RequestMapping("/compras")
public class CompraController {
	
	@Autowired
	private ICompraService service;
	
	@Autowired
	private IPacoteService pacoteService;

	@Autowired 
	private IUsuarioService usuarioService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Compra compra) {
		//String data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
		compra.setUsuario(this.getUsuario());
		compra.setStatus("VIGENTE");
		return "compra/cadastro";
	}
	
	private Usuario getUsuario() {
		UsuarioDetails usuarioDetails = (UsuarioDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = usuarioDetails.getUsername();
		Usuario usuario = usuarioService.buscarPorLogin(username);
		return usuario;
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
					
		model.addAttribute("compras",service.buscarTodosPorUsuario(this.getUsuario()));
		
		return "compra/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Compra compra, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "compra/cadastro";
		}
		
		service.salvar(compra);
		attr.addFlashAttribute("sucess", "compra.create.sucess");
		return "redirect:/compras/listar";
	}
	
	@ModelAttribute("pacotes")
	public List<Pacote> listaPacotes() {
		return pacoteService.buscarTodos();
	}
}
