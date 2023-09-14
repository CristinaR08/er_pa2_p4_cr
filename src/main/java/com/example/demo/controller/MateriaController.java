package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.IMateriaService;


@Controller
@RequestMapping("/materias")
public class MateriaController {
	
	@Autowired
	private IMateriaService materiaService;
	
	
	@GetMapping("/nueva")
	public String paginaNuevaMateria(Materia materia) {
		return "vistaNuevaMateria";
	}

	@PostMapping("/insertar")
	public String insertarMateria(Materia materia, Model modelo) {
		this.materiaService.insertar(materia);
		materia = new Materia();
		modelo.addAttribute("materia", materia);
		return "redirect:/materias/listado";
	}
	
	@GetMapping("/listado")
	public String buscarTodos(Model modelo) {
		List<Materia> lista = this.materiaService.listaMaterias();
		modelo.addAttribute("materias", lista);
		return "vistaListaMaterias";
	}

}
