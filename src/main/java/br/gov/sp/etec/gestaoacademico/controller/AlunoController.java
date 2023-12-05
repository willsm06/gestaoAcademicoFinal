package br.gov.sp.etec.gestaoacademico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.gov.sp.etec.gestaoacademico.model.Aluno;
import br.gov.sp.etec.gestaoacademico.repository.AlunoRepository;

@Controller
@RequestMapping("aluno")
public class AlunoController {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@GetMapping("cadastrar")
	public String cadastrar() {
		return "cadastro-aluno";
	}
	
	@PostMapping("salvar")
	public String salvar(Aluno aluno) {
		alunoRepository.save(aluno);
		return "index";
	}
	
}