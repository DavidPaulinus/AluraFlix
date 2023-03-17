package br.com.AluraFlix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import br.com.AluraFlix.model.Categoria;
import br.com.AluraFlix.model.record.categoria.CategoriaDTO;
import br.com.AluraFlix.util.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo;

	public Page<Categoria> listar() {
		return new PageImpl<Categoria>(repo.findAll());
	}

	public Categoria detalharPorId(Long id) {
		return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Não encontrado."));
	}

	public void cadastrar(Categoria categoria) {
		repo.save(categoria);
	}

	public Categoria atualizar(Long id, @Valid CategoriaDTO dto) {
		var cat = repo.getReferenceById(id);
		cat.atualizar(dto);
		
		return cat;
	}
	
}
