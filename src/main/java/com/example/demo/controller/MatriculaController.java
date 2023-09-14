package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.repository.modelo.MatriculaTemporal;
import com.example.demo.repository.modelo.dto.MatriculaDTO;
import com.example.demo.service.IMatriculaService;


@Controller
@RequestMapping("/matriculas")

public class MatriculaController {
	
	
	@Autowired 
	private IMatriculaService matriculaService;
	
	@GetMapping("/nuevaM")
	public String paginaNuevaMatricula(MatriculaTemporal matriculaTemporal) {
		return "vistaNuevaMatricula";
	}

	@PostMapping("/matricular")
	public String insertarMatricula(MatriculaTemporal mTemporal, Model modelo) {
		this.matriculaService.agregarMatricula(mTemporal);
		mTemporal = new MatriculaTemporal();
		modelo.addAttribute("mTemporal", mTemporal);
		return "redirect:/matriculas/buscar";
	}	
		
	@GetMapping("/reporteMatriculas")
	public String buscarTodos(Model modelo) {
		List<MatriculaDTO> lista = this.matriculaService.buscarDTO();
		modelo.addAttribute("matriculas", lista);
		return "vistaListaMatriculas";
	}


}
