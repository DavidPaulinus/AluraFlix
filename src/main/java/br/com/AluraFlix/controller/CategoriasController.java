package br.com.AluraFlix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.AluraFlix.model.Categoria;
import br.com.AluraFlix.model.record.categoria.CategoriaDTO;
import br.com.AluraFlix.model.record.categoria.CategoriaDetalharDTO;
import br.com.AluraFlix.model.record.categoria.CategoriaListarDTO;
import br.com.AluraFlix.service.CategoriaService;
import jakarta.validation.Valid;

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
	
	@PostMapping
	public ResponseEntity<CategoriaDetalharDTO> cadastrarCategoria(@RequestBody @Valid CategoriaDTO dto, UriComponentsBuilder uri){
		var categoria = new Categoria(dto);
		
		service.cadastrar(categoria);
		
		return ResponseEntity.created(
				uri.path("/categorias")
				.buildAndExpand(categoria.getId()).toUri()
				)
				.body(new CategoriaDetalharDTO(categoria));
	}
}
