package br.com.AluraFlix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import br.com.AluraFlix.model.Categoria;
import br.com.AluraFlix.util.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo;

	public Page<Categoria> listar() {
		return new PageImpl<Categoria>(repo.findAll());
	}
	
}
