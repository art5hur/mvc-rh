package com.github.art5hur.mvc_rh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.art5hur.mvc_rh.model.Funcionario;
import com.github.art5hur.mvc_rh.repository.FuncionarioRepository;

@Controller
@RequestMapping("funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@GetMapping()
	public String list(Model model) {
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		model.addAttribute("funcionarios", funcionarios);
		return "funcionario/list";
	}
	
	@PostMapping("save")
	public String save(@ModelAttribute Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
		return "redirect:/funcionarios";
	}
	
	@GetMapping("add")
	public String create(Model model) {		
		model.addAttribute("funcionario", new Funcionario());
		return "funcionario/form";
	}
}
