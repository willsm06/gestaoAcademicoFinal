package br.gov.sp.etec.gestaoacademico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org. springframework.web. bind. annotation. GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org. springframework.web.bind. annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.gov.sp.etec.gestaoacademico.model.Curso;
import br.gov.sp.etec.gestaoacademico.repository.CursoRepository;

@Controller
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	CursoRepository cursoRepository;
	
	
	@GetMapping("/cadastrar")
	public String cadastrar() {
		return "cadastro-curso";
	}
	
	@PostMapping("salvar")
	public String salvar(String nome) {
		Curso curso = new Curso();
		curso.setNome(nome);
		curso.setSigla(nome.substring(0, 3));
		cursoRepository.save(curso);
		return "/index";
	}
	
	@GetMapping("/listar")
	public ModelAndView lista() {
		List<Curso> cursos = cursoRepository.findAll();
		ModelAndView view = new ModelAndView("lista-curso");
		view.addObject("cursos",cursos);
		return view;
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		cursoRepository.deleteById(id);
		return "redirect:/curso/listar";
	}
}