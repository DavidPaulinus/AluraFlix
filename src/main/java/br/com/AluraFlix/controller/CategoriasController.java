package br.com.AluraFlix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.AluraFlix.model.record.categoria.CategoriaDetalharDTO;
import br.com.AluraFlix.model.record.categoria.CategoriaListarDTO;
import br.com.AluraFlix.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {
	@Autowired
	private CategoriaService service;
	
	@GetMapping
	public ResponseEntity<Page<CategoriaListarDTO>> listarCategorias(){
		return ResponseEntity.ok(service.listar().map(CategoriaListarDTO::new));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaDetalharDTO> detalharCategoria(@PathVariable Long id){
		return ResponseEntity.ok(new CategoriaDetalharDTO(service.detalharPorId(id)));
	}
}
