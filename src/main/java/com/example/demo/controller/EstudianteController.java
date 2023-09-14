package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

	
	@Autowired
	private IEstudianteService estudianteService;
	
	@GetMapping("/nuevo")
	public String paginaNuevoEstudiante(Estudiante estudiante) {
		return "vistaNuevoEstudiante";
	}

	@PostMapping("/insertar")
	public String insertarMateria(Estudiante estudiante, Model modelo) {
		this.estudianteService.insertar(estudiante);
		estudiante = new Estudiante();
		modelo.addAttribute("estudiante", estudiante);
		return "redirect:/estudiantes/nuevo";
	}
	
	@GetMapping("/buscar")
	public String buscarTodos(Model modelo) {
		List<Estudiante> lista = this.estudianteService.buscarTodos();
		modelo.addAttribute("estudiantes", lista);
		return "vistaListaEstudiantes";
	}
	
}
