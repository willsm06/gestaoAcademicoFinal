package br.gov.sp.etec.gestaoacademico.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.gov.sp.etec.gestaoacademico.model.Login;
import br.gov.sp.etec.gestaoacademico.repository.LoginRepository;

@Controller
public class LoginController {

	@Autowired
	LoginRepository repository;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@PostMapping("/logar")
	public String logar(String email, String password) {
		
		Login login = repository.findByEmail(email);
		
		if(login != null && login.getSenha().equals(password)){
			return "index";
		}
		return "erro";
		
	}
	
	@GetMapping("/cadastro")
	public String abrirTelaCadastroLogin() {
		return"cadastro-login";
	}
	
	
	@PostMapping("/cadastrar")
	public String salvarLogin(Login login ) {
		
		repository.save(login);
		return "redirect:/";
	}
	
	@GetMapping("/lista")
	public ModelAndView listarLogin() {
		List<Login> lista = repository.findAll();
		ModelAndView view = new ModelAndView("lista-login");
		view.addObject("logins", lista);
		return view;
	}
}
