package com.github.art5hur.mvc_rh.controller;

import java.util.List;

import com.github.art5hur.mvc_rh.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.github.art5hur.mvc_rh.model.Departamento;
import com.github.art5hur.mvc_rh.repository.DepartamentoRepository;

@Controller
@RequestMapping("departamentos")
public class DepartamentoController {

	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@GetMapping()
	public String list(Model model) {
		List<Departamento> departamentos = departamentoRepository.findAll();
		model.addAttribute("departamentos",departamentos);
		return "departamento/list";
	}
	
	@GetMapping("cargos")
	public String cargosByDepartamento() {
		return "departamento/list_cargos";
	}
	
	@GetMapping("form")
	public String form() {
		return "departamento/form";
	}
	
	@GetMapping("add")
	public String create(Model model) {		
		model.addAttribute("departamento", new Departamento());
		return "departamento/form";
	}
	
	@PostMapping("save")
	public String save(@ModelAttribute Departamento departamento) {
		departamentoRepository.save(departamento);
		return "redirect:/departamentos";
	}
	
	@GetMapping("update/{id}")
	public String update(@PathVariable Long id, Model model){
		Departamento departamento = departamentoRepository.findById(id).orElse(new Departamento());

		model.addAttribute("departamento", departamento);
		return "departamento/form";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable Long id){
		departamentoRepository.deleteById(id);
		return "redirect:/funcionarios";
	}
}
